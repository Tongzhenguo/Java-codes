/*
package data.code.redis;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public final class MyJedisPool {
    private static final Logger LOGGER = Logger.getLogger(MyJedisPool.class);
    private static int DEFAULT_DB_INDEX = 0;

    private static JedisPool jedisPool = null;

    private MyJedisPool() {
        // private constructor/

    }
    private static void initialPool() {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
//            String address = "192.168.1.52";
//            int port = Integer.valueOf(6480);
            String address = "recommendvideo44p6497.redis.yyt";
            int port = Integer.valueOf(6497);
//            String address = "localhost";
//            int port = Integer.valueOf(6379);
            LOGGER.info("Redis server info: " + address + ":" + port);

            String strDbIndex = "0";
            if (strDbIndex != null) {
                DEFAULT_DB_INDEX = Integer.valueOf(strDbIndex);
            }
            config.setMaxTotal(Integer.valueOf("512"));
            String strMaxIdle = "200";
            if (strMaxIdle != null) {
                config.setMaxIdle(Integer.valueOf(strMaxIdle));
            }
            String maxWaitMillis = "1000";
            if (maxWaitMillis != null) {
                config.setMaxWaitMillis(Integer.valueOf(maxWaitMillis));
            }
            String strTestOnBorrow = "true";
            if (strTestOnBorrow != null) {
                config.setTestOnBorrow(Boolean.valueOf(strTestOnBorrow));
            }
            String strTestOnReturn = "true";
            if (strTestOnReturn != null) {
                config.setTestOnReturn(Boolean.valueOf(strTestOnReturn));
            }
            String strTimeout = "2000";
            int timeout = 2000;//
            if (strTimeout != null) {
                timeout = Integer.valueOf(strTimeout);
            }
            jedisPool = new JedisPool(config, address, port, timeout);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }

    public synchronized static Jedis getJedisInstance() {
        if (jedisPool == null) {
            initialPool();
        }
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                resource.select(DEFAULT_DB_INDEX);
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized static Jedis getJedisInstance(final int dbIndex) {
        if (jedisPool == null) {
            initialPool();
        }
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                resource.select(dbIndex);
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }
}*/
