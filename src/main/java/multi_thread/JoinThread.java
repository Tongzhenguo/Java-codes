package multi_thread;

/**
 * Created by arachis on 2017/4/23.
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 */

public class JoinThread extends Thread{
    public JoinThread(String name){
        super(name);
    }

    public void run(){
        for(int i=0; i<10; i++){
            for(long k=0; k<100000000; k++){}

            System.out.println(this.getName() + ": " + i);
        }
    }

    public static void main(String[] args){

        Thread t1 = new JoinThread("T1");
        Thread t2 = new JoinThread("T2");
        t1.start();
        try{
            t1.join();//Join在这里~
            t2.start();
            t2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("T3");
    }
}
