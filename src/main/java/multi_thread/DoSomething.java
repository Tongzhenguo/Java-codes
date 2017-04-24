package multi_thread;

/**
 * Created by arachis on 2017/4/23.
 */
/**
 * 实现Runnable接口的类
 *
 */
public class DoSomething implements Runnable {
    private String name;

    public DoSomething(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            for (long k = 0; k < 100000000; k++) ;
            System.out.println(name + ": " + i);
        }
    }
}
