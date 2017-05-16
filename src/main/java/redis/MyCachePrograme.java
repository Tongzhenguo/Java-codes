/*
package redis;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

*/
/**
 * 在mysql请求过大的情况下，将数据缓存在redis
 * 先去redis取，没有再去mysql取；并且写入redis
 * 每查询2000次，暂停2s
 * redis的数据类型选用Hash类型
 *//*

public class MyCachePrograme {

    static final String  host = "***";
    static final int port =  8000;
    private static final int batchSize = 2000;
    private static Jedis jedis = null;
    private static long index = 0;
    private static Connection mv_user_info = null;
    private static Logger LOGGER = Logger.getLogger(MyCachePrograme.class);
    static {
        try {
            jedis = new Jedis(host, port);
            mv_user_info = DriverManager.getConnection("*********");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> batchGetVideoInfo2(Set<String> vids){
        List<String> list = new ArrayList<String>(vids.size());
        for(String videoID :vids){
            index++;
            if(index%batchSize ==0){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String videoInfo = "";
            if(jedis.exists(videoID)){
                //在缓存中，从缓存中取
                videoInfo += jedis.get(videoID);
                list.add(videoID+","+videoInfo);
            }else {
                setVidArea(videoID);
                setVidSourceType(videoID);
                String area = jedis.hget(videoID, "area");
                String type = jedis.hget(videoID, "type");
                list.add(videoID+","+area+","+type);
                //设置过期时间
                jedis.expire(videoID, 30*24*3600);
            }
        }
        closeConnection();
        return null;
    }

    public static void setVidArea(String videoID){
        String sql = "******";
        ResultSet rs = null;
        Statement stat = null;
        String area = null;
        try {
            stat = mv_user_info.createStatement();
            rs = stat.executeQuery(sql);
            area = null;
            if(rs.getRow() == 0){
                //如果没有地区信息，就返回空串
                area =  "null";
            }
            while(rs.next()){
                area = rs.getString(1);
            }
            jedis.hset(videoID,"area",area);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setVidSourceType(String videoID){
        ResultSet rs = null;
        Statement stat = null;
        try {
            String sql = "****** ";
            stat = mv_user_info.createStatement();
            rs = stat.executeQuery(sql);
            String type = null;
            if(rs.getRow() == 0){
                //如果没有信息，就返回null
                type = "null";
            }
            while(rs.next()){
                type = rs.getString(1);
            }
            jedis.hset(videoID, "type", type);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    static class SingletonHolder {
        static MyCachePrograme instance = new MyCachePrograme();
    }

    public static MyCachePrograme getInstance() {
        return SingletonHolder.instance;
    }

    public static void closeConnection(){
        try {
            mv_user_info.close();
            jedis.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
*/
