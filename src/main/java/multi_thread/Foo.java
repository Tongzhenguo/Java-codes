package multi_thread;

/**
 * Created by arachis on 2017/4/23.
 * 把竞争访问的资源类Foo变量x标识为private；
 同步哪些修改变量的代码，使用synchronized关键字同步方法或代码。


 Java中每个对象都有一个内置锁
 当程序运行到非静态的synchronized同步方法上时，自动获得与正在执行代码类的当前实例（this实例）有关的锁。获得一个对象的锁也称为获取锁、锁定对象、在对象上锁定或在对象上同步。
 当程序运行到synchronized同步方法或代码块时才该对象锁才起作用。
 一个对象只有一个锁。所以，如果一个线程获得该锁，就没有其他线程可以获得锁，直到第一个线程释放（或返回）锁。这也意味着任何其他线程都不能进入该对象上的synchronized方法或代码块，直到该锁被释放。
 释放锁是指持锁线程退出了synchronized同步方法或代码块。
 *
 */

public class Foo {
    private int x = 100;

    public int getX() {
        return x;
    }

    public int fix(int y) {
        x = x - y;
        return x;
    }
}
