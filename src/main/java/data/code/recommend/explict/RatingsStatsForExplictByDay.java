package data.code.recommend.explict;


import com.yinyuetai.common.SysConstant;
import com.yinyuetai.pojos.UserOperation;
import com.yinyuetai.recommend.Config;
import com.yinyuetai.utils.BusinessUtil;
import com.yinyuetai.utils.DateUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

/**
 * 用户对艺人显式评分（经验加权），按天计算
 * @author Zealot
 * @date 2016年7月19日
 */
public class RatingsStatsForExplictByDay implements Serializable{
	
	protected static Logger log = LoggerFactory.getLogger(RatingsStatsForExplictByDay.class);
	static Date yesterday = DateUtils.plusDays(new Date(), -1);
	private static String DATE =DateUtils.toDateString(yesterday);
	public RatingsStatsForExplictByDay(String date){
		DATE=date;
	}
	public RatingsStatsForExplictByDay() {
	}

	public void doJob( Date startDate) throws Exception {
		SparkConf conf = new SparkConf().setAppName(RatingsStatsForExplictByDay.class.toString());
		JavaSparkContext sc = new JavaSparkContext(conf);
		long start = System.currentTimeMillis();
	    String rePath =  Config.uid_aid_rating;
		final String date =DateUtils.toDateString(startDate);
		String path2 = "/user/hanshuai/merged/user_operation/" + date + "/log.txt";
		System.out.println("====================path:" + path2);
		 JavaRDD<String> flumeData = 
				sc.textFile(path2).filter(new Function<String, Boolean>() {
					@Override
					public Boolean call(String v1) throws Exception {
						String[] ss = v1.split(",");
						if (ss.length < 13) {
							return false;
						}
						String uid = ss[3];
						String aid = ss[SysConstant.USER_OPERATION_ARTIST_ID];

						if ("".equals(aid)) {
							return false;
						}
						String operationType = ss[SysConstant.USER_OPERATION_OPERATION_TYPE];
						String r = ss[SysConstant.USER_OPERATION_R];
						if ("1".equals(operationType)) {
							// 只统计播放进度在80%以上的视频，相当于完整播放
							if (!"8".equals(r)) {
								return false;
							}
						}
						return !"0".equals(uid) && BusinessUtil.isNumeric(uid)
								&& BusinessUtil.isNumeric(aid);
					}
				});
	    
	    flumeData
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
				return uid_aid+","+weight+","+date;
			}
		})
		.repartition(10)
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
		
		.saveAsTextFile(rePath+date);
	
		long end = System.currentTimeMillis();
		long rangeMs = end - start;
		long sec = rangeMs / 1000;
		System.out.println("take " + sec + " seconds :"+rePath+date);
		sc.close();
	}
	
	
	
	public static void main(String[] args) {
		log.info("==================================start "+ RatingsStatsForExplictByDay.class.toString());
		String start = null;
		String end = null;
		if (args.length > 0) {
			start = args[0];
			end = args[1];
		}
		RatingsStatsForExplictByDay ufs = new RatingsStatsForExplictByDay();
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = DateUtils.parse2Date(start, "yyyy-MM-dd");
			endDate = DateUtils.parse2Date(end, "yyyy-MM-dd");

			long diff = endDate.getTime() - startDate.getTime() + 1;
			long n = diff / (1000 * 60 * 60 * 24);
			for (int i = 0; i > -n; i--) {
				Date day = DateUtils.plusDays(endDate, i);
				ufs.doJob(day);
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
