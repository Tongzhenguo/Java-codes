/*
package redis;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

public class RedisGuide {

    static final String host = "192.168.228.128";
    static final int port = 6379;
    private static final int batchSize = 2000;
    private static Jedis jedis = null;
    private static Logger LOGGER = Logger.getLogger(RedisGuide.class);

    static {
        jedis = new Jedis(host, port);
    }

    public static void main(String[] args) {
        */
/*jedis.set("1","a");
        jedis.del("1");
        jedis.incr("1.1");
        jedis.decr("1.1");
        jedis.del("1.1");
        System.out.println(jedis.get("1").toString());
        *//*

        */
/*jedis.lpush("11","a1","b1");
        System.out.println(jedis.lrange("11",0,4));
        System.out.println(jedis.lpop("11"));*//*

        jedis.rpush("a","1","2");

        //jedis.mset("1","1","2","2");//设置多个key-value(1:1和2:2两个键值对)
        */
/**
         * String类型还提供获取字符串长度
         * 往字符串append内容
         * 设置或获取字符串的某一段内容
         * 设置及获取字符串的某一位（bit）
         * 批量设置一系列字符串的内容
         *//*



    }
}*/
