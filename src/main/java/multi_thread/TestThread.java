package multi_thread;

/**
 * Created by arachis on 2017/4/23.
 */


/**
 * 测试扩展Thread类实现的多线程程序
 */
public class TestThread extends Thread{
    public TestThread(String name) {
        super(name);
    }

    public void run() {
        for(int i = 0;i<5;i++){
            for(long k= 0; k <100000000;k++);
            System.out.println(this.getName()+" :"+i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new TestThread("阿三");
        Thread t2 = new TestThread("李四");
        t1.start();
        t2.start();
    }
}
