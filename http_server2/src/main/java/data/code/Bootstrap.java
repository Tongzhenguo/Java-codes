//package data.code;
//
///**
// * Created by tongzhenguo on 2019/5/30.
// */
//import com.meitu.rpc.netty4.http.HttpNettyNioServer;
//import data.code.constant.ServerConst;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class Bootstrap {
//
//    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);
//
//    public static void main(String[] args) throws Exception {
//
//        HttpNettyNioServer httpServer = new HttpNettyNioServer.HttpNettyNioServerBuilder()
//                .setName(ServerConst.SERVER_NAME)
//                .setVersion(ServerConst.SERVER_VERSION)
//                .setMaxContentLength(ServerConst.SERVER_MAX_CONTENT_LEN)
//                .setBossThreads(ServerConst.SERVER_BOSS_THREAD_NUM)
//                .setWorkerThreads(ServerConst.SERVER_WORKER_THREAD_NUM)
//                .setPort(ServerConst.SERVER_PORT)
//                .setSoRcvbuf(ServerConst.SERVER_SO_RCV_BUF)
//                .setSoBacklog(ServerConst.SERVER_SO_BACKLOG)
//                .setTcpNoDelay(ServerConst.SERVER_TCP_NO_DELAY)
//                .setSoKeepAlive(ServerConst.SERVER_SO_KEEP_ALIVE)
//                .addHttpUrlRequest(scoreHandler)
//                .addHttpUrlRequest(updateHandler)
//                .addHttpUrlRequest(killHandler)
//                .build();
//
//        httpServer.start();
//
//        httpServer.stop();
//    }
//}
//
//
