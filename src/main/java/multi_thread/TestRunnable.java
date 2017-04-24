package multi_thread;

/**
 * Created by arachis on 2017/4/23.
 */
/**
 * 测试Runnable类实现的多线程程序
 */
public class TestRunnable {
    public static void main(String[] args) {
        DoSomething ds1 = new DoSomething("阿三");
        DoSomething ds2 = new DoSomething("李四");

        Thread t1 = new Thread(ds1);
        Thread t2 = new Thread(ds2);

        t1.start();
        t2.start();
    }
}