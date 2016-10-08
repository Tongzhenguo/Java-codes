package data.code.recommend.explict;


import com.yinyuetai.common.SysConstant;
import com.yinyuetai.pojos.UserOperation;
import com.yinyuetai.recommend.Config;
import com.yinyuetai.utils.BusinessUtil;
import com.yinyuetai.utils.DateUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户对艺人显式评分（经验加权），全量计算
 * @author Zealot
 * @date 2016年4月12日
 */
public class RatingsStatsForExplict implements Serializable{
	
	protected static Logger log = LoggerFactory.getLogger(RatingsStatsForExplict.class);
	static Date yesterday = DateUtils.plusDays(new Date(), -1);
	private static String DATE =DateUtils.toDateString(yesterday);
	public RatingsStatsForExplict(String date){
		DATE=date;
	}
	public RatingsStatsForExplict() {
	}

	public void doJob(String num) throws Exception {
		int n = Integer.parseInt(num);
		SparkConf conf = new SparkConf().setAppName(RatingsStatsForExplict.class.toString());
		JavaSparkContext sc = new JavaSparkContext(conf);
		long start = System.currentTimeMillis();
	    String rePath =  Config.artist_InPathExplict;
	    List<String> l = new ArrayList<String>();
	    JavaRDD<String> flumeData = sc.parallelize(l);
	    for(int i = -1; i >= -n; i--) {
	    	Date yesterday = DateUtils.plusDays(new Date(), i);
			String date =DateUtils.toDateString(yesterday);
			 String path2 = "/user/hanshuai/merged/user_operation/"+date+"/log.txt";
			 System.out.println("====================path:"+path2);
			 flumeData = flumeData.union(sc.textFile(path2)
					 .filter(new Function<String, Boolean>() {
							@Override
							public Boolean call(String v1) throws Exception {
								String[] ss = v1.split(",");
								if(ss.length<13){
									return false;
								} 
								String uid  =ss[3];
								String aid  =ss[SysConstant.USER_OPERATION_ARTIST_ID];
								
								if("".equals(aid)){
									return false;
								}
								String operationType = ss[SysConstant.USER_OPERATION_OPERATION_TYPE];
								String r = ss[SysConstant.USER_OPERATION_R];
								if("1".equals(operationType)){
									//只统计播放进度在80%以上的视频，相当于完整播放
									if(!"8".equals(r)){
										return false;
									}
								}
								return !"0".equals(uid)&&BusinessUtil.isNumeric(uid)&&BusinessUtil.isNumeric(aid);
							}
						}))
						.repartition(10);
	    }
	    
	    flumeData
	    .flatMap(new FlatMapFunction<String, String>() {

			@Override
			public Iterable<String> call(String t) throws Exception {
				List<String> list = new ArrayList<String>();
				String[] ss = t.split(",");
		        String artistId = ss[SysConstant.USER_OPERATION_ARTIST_ID];
		        if(artistId.contains("-")){//如果艺人id包含多个，则分开
		            String[] artistIds = artistId.split("-");
		            for(String aid: artistIds){
		            	ss[SysConstant.USER_OPERATION_ARTIST_ID] = aid;
		            	StringBuilder newLine  =new StringBuilder();
		            	for(int i = 0; i < ss.length; i++){
		            		newLine.append(ss[i]).append(",");
		            	}
		            	String newLineStr = newLine.toString();
		                list.add(newLineStr.substring(0, newLineStr.length()-1));
		            }
		        }else{
		            list.add(t);
		        }
				return list;
			}
		})
	    .mapToPair(new PairFunction<String, String, Integer>() {
			@Override
			public Tuple2<String, Integer> call(String str) throws Exception {
				UserOperation userOperation = UserOperation.getUserOperationByStr4Flume2(str);
				
				return new Tuple2<String, Integer>(userOperation.getUserId()+"-"+userOperation.getArtistId(),userOperation.getWeight());
			}})
		.reduceByKey(new Function2<Integer, Integer, Integer>() {
			@Override
			public Integer call(Integer v1, Integer v2) throws Exception {
				return v1+v2;
			}
			
		})
		.map(new Function<Tuple2<String,Integer>, String>() {

			@Override
			public String call(Tuple2<String, Integer> v1) throws Exception {
				String uid_aid=v1._1().replace("-", ",");
				int weight = v1._2();
				return uid_aid+","+weight;
			}
		})
		.repartition(100)
		.filter(new Function<String, Boolean>() {//把0去掉
			
			@Override
			public Boolean call(String v1) throws Exception {
				String[] ss = v1.split(",");
				if("0".equals(ss[2])){
					
					return false;
				}
				return true;
			}
		})
		.saveAsTextFile(rePath);
	
		long end = System.currentTimeMillis();
		long rangeMs = end - start;
		long sec = rangeMs / 1000;
		System.out.println("take " + sec + " seconds :");

	}
	
	
	
	public static void main(String[] args) {
		log.info("==================================start "+RatingsStatsForExplict.class.toString());
		String num="";
		if (args.length > 0) {
			num = args[0];
		}else{
			num ="30";
		}
		RatingsStatsForExplict ufs = new RatingsStatsForExplict();
		try {
			ufs.doJob(num);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
