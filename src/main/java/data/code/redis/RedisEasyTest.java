/*
package data.code.redis;

import org.apache.commons.lang.math.RandomUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class RedisEasyTest {  
	static String host = "192.168.1.168";
	static int port = 6379;
    private static Jedis jedis = new Jedis(host,port);  
  
    private static Pipeline p = jedis.pipelined();  
  
    private static int KEY_COUNT = 10000;  
  
    private static int FIELD_COUNT = 10;  
  
    public void single() {  
        for (int i = 0; i < KEY_COUNT; i++) {  
            String key = RandomUtils.nextInt(5) + "";  
            for (int j = 0; j < FIELD_COUNT; j++) {  
                jedis.hset(key, j + "", i + j + "");  
                jedis.expire(key, 3600);  
            }  
        }  
    }  
  
    public void batch() {  
        int index = 0;  
        for (int i = 0; i < KEY_COUNT; i++) {  
            String key = RandomUtils.nextInt(5) + "";  
            for (int j = 0; j < FIELD_COUNT; j++) {  
                p.hset(key, j + "", i + j + "");  
                p.expire(key, 3600);  
            }  
            if (++index % 1000 == 0) {  
                p.sync();  
            }  
        }  
        p.sync();  
    }  
  
    public static void main(String[] args) {  
        long start = System.currentTimeMillis();  
        RedisEasyTest r = new RedisEasyTest();  
        r.single();  
        System.out.printf("single use %d sec \n", (System.currentTimeMillis() - start) / 1000);  
        start = System.currentTimeMillis();  
        r.batch();  
        System.out.printf("batch use %d sec \n", (System.currentTimeMillis() - start) / 1000);  
  
    }  
}  */
