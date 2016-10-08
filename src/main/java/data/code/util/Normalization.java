package data.code.util;

import java.io.Serializable;
import java.util.Collections;
import java.util.Vector;

/**
 * Created by YYT on 2016/9/27.
 * 常见的数据标准化实现
 * 需要进行标准化的情形：
      我们需要计算距离;
      不同特性之间的尺度相差很大。
 */
public class Normalization implements Serializable{
    public static double[][] data = {
            {2,7500.0,15.0},
            {22.0,4500.0,25.0},
            {1.0,1500.0,45.0}
    };

    /**
     * 通过列索引获取特征向量
     * @param columnIdx
     * @param data
     * @return
     */
    public static Vector<Double> getVectorByColumnIdx(int columnIdx,double[][] data){
        int m = data.length; //样本数
        Vector<Double> vector = new Vector<Double>(m);
        for(int i=0;i< m;i++) {
            vector.add(data[i][columnIdx]);
        }
        return vector;
    }

    /*
    *   实现单机版计算最大最小标准化
    */
    public static double[] minmax(int columnIdx,double[][] data){
          double[] vector = new double[data.length];
          double maxValue = 0.0;
          double minValue = 0.0;
          for(int i=0;i<data.length;i++){
              vector[i] = data[i][columnIdx];
              maxValue = Math.max(maxValue,vector[i]);
              minValue = Math.min(minValue,vector[i]);
          }
          for (int i=0;i<data.length;i++){
              vector[i] = ( vector[i] - minValue ) / ( maxValue - minValue);
          }
        return vector;
    }

    /**
     *  获取样本均值
     */
    public static double getMean(int columnIdx,double[][] data){
        double sum = 0.0;
        double mean = 0.0;
        int m = data.length; //样本数
        for(int i=0;i< m;i++){
            sum+=data[i][columnIdx];
        }
        if(m > 0){
            mean = sum / m;
        }
        return mean;
    }

    /**
     *  获取样本标准差
     */
    public static double getStandardDeviation(int columnIdx,double[][] data){
        double mean = getMean(columnIdx,data);
        double variance = 0.0;//方差
        double sd = 0.0;
        int m = data.length;
        for(int i=0;i< m;i++){
            variance +=(1.0/m) * Math.pow((data[i][columnIdx] - mean), 2);
        }
        sd = Math.sqrt(variance);
        return sd;
    }
    /**
     *  实现单机版标准分标准化
     *  特点：不用计算最大最小值，但是会受异常者影响（异常高的值会拉高均值）
     */
    public static double[] zscore(int columnIdx,double[][] data){
        int m = data.length; //样本数
        double[] vector = new double[m];
        double u = getMean(columnIdx,data); //样本均值
        double s = getStandardDeviation(columnIdx,data); //标准差
        if(s != 0){
            for (int i=0;i< m;i++){
                vector[i] = (data[i][columnIdx] - u) / s;
            }
        }
        return vector;
    }

    /**
     * 获取向量的中位数
     * @param columnIdx:特征所在列序号
     * @param data：数据集
     * @return 特征向量的中位数（排序后取中间的数）
     */
    public static double getMedian(int columnIdx,double[][] data){
        double median = 0.0;
        int m = data.length;
        Vector<Double> vector = new Vector<Double>(m);
        for (int i=0;i<m;i++){
            vector.add(data[i][columnIdx]);
        }
        Collections.sort(vector);
        if(m % 2 == 1){//奇数个取中间的
            int midx = 0;//中位数所在的index
            midx = m / 2;
            median = vector.get(midx);
        }else {      //偶数个取两个数的均值
            median = ( vector.get(m/2-1) + vector.get(m/2) ) / 2;
        }
        return median;
    }

    /**
     * 获取向量的绝对偏差
     * @param columnIdx:特征所在列序号
     * @param data：数据集
     * @return
     */
    public static double getAbsoluteDeviation(int columnIdx,double[][] data){
        Vector<Double> vector = getVectorByColumnIdx(columnIdx, data);
        int m = vector.size();
        double mean = getMean(columnIdx, data);
        double sum = 0;
        double asd = 0;
        for(Double d:vector){
            sum += Math.abs(d - mean);
        }
        if(m > 0){
            asd = sum / m;
        }
        return asd;
    }

    /**
     * 修正后的标准分克服了异常值干扰的问题
     * @param columnIdx
     * @param data
     * @return
     */
    public static Vector<Double> modefiedStandardScore(int columnIdx, double[][] data){
        Vector<Double> vector = getVectorByColumnIdx(columnIdx, data);
        int m = vector.size();
        double median = getMedian(columnIdx, data);
        double asd = getAbsoluteDeviation(columnIdx, data);
        for(int i =0;i<m;i++){
            vector.set(i,((vector.get(i) - median) / asd));
        }
        return vector;
    }
    public static void main(String[] args) {
     /*   assert(getMean(1,data) == 7.0/3);
        System.out.println("getMean success");*/
       /* System.out.println(getStandardDeviation(1,data));*/
        double[] normal = minmax(1, data);
        double[] zscore = zscore(1, data);
        Vector<Double> mss = modefiedStandardScore(1, data);
        for(int i=0;i<normal.length;i++) {
            System.out.println("最大最小标准化："+normal[i]);
            System.out.println("标准分:"+zscore[i]);
            System.out.println("修正后的标准分："+mss.get(i));
        }
        assert(getMedian(0,data) == 2.0);
        System.out.println("getMedian is right");
        assert(getVectorByColumnIdx(0,data).get(1) == 2.0);
        assert(getAbsoluteDeviation(0,data) == 2.0/3);
    }

}
