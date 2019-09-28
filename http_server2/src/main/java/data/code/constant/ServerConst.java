package data.code.constant;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by tongzhenguo on 2019/5/30.
 */

public class ServerConst {
    public static String SERVER_NAME = "Rec-Http-Server";
    public static String SERVER_VERSION = "unknown";
    public static int SERVER_MAX_CONTENT_LEN = 5 * 1024 * 1024;
    public static int SERVER_BOSS_THREAD_NUM = 2;
    public static int SERVER_WORKER_THREAD_NUM = 2;
    public static int SERVER_PORT = 9801;
    public static int SERVER_SO_RCV_BUF = 64 * 1024;
    public static int SERVER_SO_BACKLOG = 1000;
    public static boolean SERVER_TCP_NO_DELAY = true;
    public static boolean SERVER_SO_KEEP_ALIVE = true;

    public static void updateConst() {
        RootPath.updateConst();

        try {
            File fXmlFile = new File(RootPath.configFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            Element eleSever = (Element) doc.getElementsByTagName("server").item(0);

            SERVER_NAME = eleSever.getElementsByTagName("ServerName").item(0).getTextContent();
            SERVER_VERSION = eleSever.getElementsByTagName("ServerVersion").item(0).getTextContent();
            SERVER_MAX_CONTENT_LEN = Integer.parseInt(eleSever.getElementsByTagName("ServerMaxContentLen").item(0).getTextContent());
            SERVER_BOSS_THREAD_NUM = Integer.parseInt(eleSever.getElementsByTagName("ServerBossThreadNum").item(0).getTextContent());
            SERVER_WORKER_THREAD_NUM = Integer.parseInt(eleSever.getElementsByTagName("ServerWorkerThreadNum").item(0).getTextContent());
            SERVER_PORT = Integer.parseInt(eleSever.getElementsByTagName("ServerPort").item(0).getTextContent());
            SERVER_SO_RCV_BUF = Integer.parseInt(eleSever.getElementsByTagName("ServerSoRcvBuf").item(0).getTextContent());
            SERVER_SO_BACKLOG = Integer.parseInt(eleSever.getElementsByTagName("ServerSoBacklog").item(0).getTextContent());
            SERVER_TCP_NO_DELAY = Boolean.parseBoolean(eleSever.getElementsByTagName("ServerTCPNoDelay").item(0).getTextContent());
            SERVER_SO_KEEP_ALIVE = Boolean.parseBoolean(eleSever.getElementsByTagName("ServerSoKeepAlive").item(0).getTextContent());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
