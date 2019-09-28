//package data.code;
//
///**
// * Created by tongzhenguo on 2019/5/30.
// */
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpHost;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpRequestRetryHandler;
//import org.apache.http.client.ResponseHandler;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.protocol.HttpClientContext;
//import org.apache.http.config.Registry;
//import org.apache.http.config.RegistryBuilder;
//import org.apache.http.config.SocketConfig;
//import org.apache.http.conn.ConnectTimeoutException;
//import org.apache.http.conn.routing.RouteInfo;
//import org.apache.http.conn.socket.ConnectionSocketFactory;
//import org.apache.http.conn.socket.PlainConnectionSocketFactory;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.*;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.impl.conn.SystemDefaultDnsResolver;
//import org.apache.http.protocol.HttpContext;
//import org.apache.http.util.EntityUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.io.InterruptedIOException;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.Arrays;
//import java.util.Map;
//
//public class HttpClientPool {
//
//    private static final Logger logger = LoggerFactory.getLogger(HttpClientPool.class);
//
//    private CloseableHttpClient httpClient;
//
//    private RequestConfig requestConfig;
//
//    public HttpClientPool(int connectionRequestTimeout, int connectTimeout, int socketTimeout, int maxConnTotal, int maxConnPerRoute, boolean soKeepAlive, boolean tcpNoDelay, final int retryTimes, final long otherWiseKeepAliveMills) {
//        logger.info("Initialize http client instances pool");
//
//        if (httpClient == null) {
//            DefaultConnectionKeepAliveStrategy keepAliveStrategy = new DefaultConnectionKeepAliveStrategy() {
//                @Override
//                public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
//                    long keepAlive = super.getKeepAliveDuration(response, context);
//                    if (keepAlive == -1) {
//                        keepAlive = otherWiseKeepAliveMills;
//                    }
//                    return keepAlive;
//                }
//            };
//
//            HttpRequestRetryHandler requestRetryHandler = new HttpRequestRetryHandler() {
//                @Override
//                public boolean retryRequest(IOException e, int executionCount, HttpContext context) {
//                    if (executionCount >= retryTimes) {
//                        return false;
//                    }
//                    if (e instanceof ConnectTimeoutException || e instanceof UnknownHostException || e instanceof InterruptedIOException) {
//                        return false;
//                    }
//                    return true;
//                }
//            };
//
//            DefaultHttpRequestRetryHandler retryHandler = new DefaultHttpRequestRetryHandler(retryTimes, false);
//
//            Registry<ConnectionSocketFactory> reg = RegistryBuilder.<ConnectionSocketFactory>create()
//                    .register("http", PlainConnectionSocketFactory.INSTANCE)
//                    .build();
//
//            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(reg);
//            cm.setDefaultMaxPerRoute(maxConnPerRoute);
//            cm.setMaxTotal(maxConnTotal);
//
//            requestConfig = RequestConfig.custom()
//                    .setConnectionRequestTimeout(connectionRequestTimeout)
//                    .setConnectTimeout(connectTimeout)
//                    .setSocketTimeout(socketTimeout)
//                    .build();
//
//            SocketConfig socketConfig = SocketConfig.custom().setSoKeepAlive(soKeepAlive).setTcpNoDelay(tcpNoDelay).build();
//
//            httpClient = HttpClientBuilder.create()
//                    .setConnectionManager(cm)
//                    .setDefaultRequestConfig(requestConfig)
//                    .setDefaultSocketConfig(socketConfig)
//                    .setRetryHandler(retryHandler)
//                    .setKeepAliveStrategy(keepAliveStrategy)
//                    .setRetryHandler(requestRetryHandler)
//                    .build();
//        }
//        if (httpClient == null) {
//            httpClient = HttpClients.createDefault();
//        }
//        logger.info("Initialize http client instances, ConnectTimeout:{}, SocketTimeout:{}, ConnectionRequestTimeout:{}, soKeepAlive:{}, tcpNoDelay:{}, MaxConnTotal:{}, MaxConnPerRoute:{}", connectTimeout, socketTimeout, connectionRequestTimeout, soKeepAlive, tcpNoDelay, maxConnTotal, maxConnPerRoute);
//    }
//
//    public void close() {
//        logger.info("close http client...");
//        if (httpClient != null) {
//            try {
//                httpClient.close();
//                httpClient = null;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void check() {
//        if (httpClient == null) {
//            httpClient = HttpClients.createDefault();
//        }
//    }
//
//    //lvs->proxy->app
//    public String stringEntityPost(String url, String params, Map<String, String> headers) throws IOException {
//        check();
//        StringEntity entity = new StringEntity(params, ContentType.APPLICATION_JSON);
//        HttpPost httpPost = new HttpPost(url);
//        if (headers != null && headers.size() > 0) {
//            for (Map.Entry<String, String> entry : headers.entrySet()) {
//                httpPost.addHeader(entry.getKey(), entry.getValue());
//            }
//        }
//        httpPost.setConfig(requestConfig);
//        httpPost.setEntity(entity);
//
//        HttpClientContext context = HttpClientContext.create();
//        try {
//            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
//                @Override
//                public String handleResponse(HttpResponse response) throws IOException {
//                    HttpEntity entity = response.getEntity();
//                    return entity == null ? null : EntityUtils.toString(entity, "UTF-8");
//                }
//            };
//            return httpClient.execute(httpPost, responseHandler, context);
//        } catch (Exception e) {
//            RouteInfo httpRoute = context.getHttpRoute();
//            HttpHost host = null;
//            if (httpRoute != null && httpRoute.getProxyHost() != null) {
//                host = httpRoute.getProxyHost();
//            } else {
//                host = context.getTargetHost();
//            }
//            InetAddress[] remoteAddresses = host.getAddress() != null ?
//                    new InetAddress[]{host.getAddress()} : SystemDefaultDnsResolver.INSTANCE.resolve(host.getHostName());
//            String message = (host != null ? host.toHostString() : "remote host") +
//                    (remoteAddresses != null ? " " + Arrays.asList(remoteAddresses) : "");
//
//            logger.debug("exec post request failed:{}，message:{}", e.getMessage(), message);
//            throw new IOException(e);
//        }
//    }
//
//
//}
