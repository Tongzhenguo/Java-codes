package multi_thread;

/**
 * Created by arachis on 2017/4/23.
 * 在使用线程池之前，必须知道如何去创建一个线程池
 * 在Java5中，需要了解的是java.util.concurrent.Executors类的API，这个类提供大量创建连接池的静态方法，是必须掌握的。
 */

import java.util.concurrent.*;


public class Test {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"正在执行。。。");
        }
    }

    public static void main(String[] args) {
/*        //创建一个可重用固定线程数的线程池
//        ExecutorService pool = Executors.newFixedThreadPool(2);


        //创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
//        ExecutorService pool = Executors.newSingleThreadExecutor();

        //创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。
        ExecutorService pool = Executors.newCachedThreadPool();

        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        //关闭线程池
        pool.shutdown();*/


/*        //创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
//        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);

        //创建一个单线程执行程序，它可安排在给定延迟后运行命令或者定期地执行。
//        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();

        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        //使用延迟执行风格的方法
        pool.schedule(t4, 10, TimeUnit.MILLISECONDS);
        pool.schedule(t5, 10, TimeUnit.MILLISECONDS);
        //关闭线程池
        pool.shutdown();*/


        /**
         * 自定义线程池
         */
        //创建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
        //创建一个单线程执行程序，它可安排在给定延迟后运行命令或者定期地执行。

        /**
         * 参数：
         corePoolSize - 池中所保存的线程数，包括空闲线程。
         maximumPoolSize - 池中允许的最大线程数。
         keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
         unit - keepAliveTime 参数的时间单位。
         workQueue - 执行前用于保持任务的队列。此队列仅保持由 execute 方法提交的 Runnable 任务。
         */


        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,3,2,TimeUnit.MILLISECONDS,bqueue);
        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        Thread t6 = new MyThread();
        Thread t7 = new MyThread();
        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t7);
        //关闭线程池
        pool.shutdown();








    }
}

