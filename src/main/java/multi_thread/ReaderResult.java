package multi_thread;

/**
 * Created by arachis on 2017/4/23.
 */

/**
 * 获取计算结果并输出
 */
public class ReaderResult extends Thread {
    Calculator c;

    public ReaderResult(Calculator c) {
        this.c = c;
    }

    public void run() {
        synchronized (c) {
            try {
                System.out.println(Thread.currentThread() + "等待计算结果。。。");
                c.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "计算结果为：" + c.total);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        //启动三个线程，分别获取计算结果
        new ReaderResult(calculator).start();
        new ReaderResult(calculator).start();
        new ReaderResult(calculator).start();
        //启动计算线程
        calculator.start();
    }
}
