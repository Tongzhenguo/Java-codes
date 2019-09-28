package data.code.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.nio.file.Paths;

/**
 * Created by zhuangguohua on 2017/12/12.
 */
public class RootPath {

    private static final Logger logger = LoggerFactory.getLogger(RootPath.class);

    public static String configFilePath = null;
    public static String configRedisPath = null;
    public static String configScorerPath = null;

    public static void updateConst() {
        if (null == configFilePath) {
            String jarPath = null;

            try {
                jarPath = ServerConst.class
                        .getProtectionDomain()
                        .getCodeSource()
                        .getLocation().toURI().getPath();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            String homePath = Paths.get(jarPath).getParent().toAbsolutePath().toString();
            configFilePath = homePath + "/../conf/server.xml";
            configRedisPath = homePath + "/../conf/redis.xml";
            configScorerPath = homePath + "/../conf/scorer.xml";
            logger.info("configFilePath = " + configFilePath);
            logger.info("configRedisPath = " + configRedisPath);
            logger.info("configScorerPath = " + configScorerPath);
        }
    }
}