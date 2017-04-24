package multi_thread;

/**
 * Created by arachis on 2017/4/23.
 * 1、线程睡眠是帮助所有线程获得运行机会的最好方法。
 2、线程睡眠到期自动苏醒，并返回到可运行状态，不是运行状态。sleep()中指定的时间是线程不会运行的最短时间。因此，sleep()方法不能保证该线程睡眠到期后就开始执行。
 3、sleep()是静态方法，只能控制当前正在运行的线程。
 */

/**
 * 一个计数器，计数到100，在每个数字之间暂停1秒，每隔10个数字输出一个字符串
 */
public class MyThread extends Thread {

    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i) % 10 == 0) {
                System.out.println("-------" + i);
            }
            System.out.print(i);
            try {
                Thread.sleep(1);
                System.out.print("    线程睡眠1毫秒！\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
    }
}
