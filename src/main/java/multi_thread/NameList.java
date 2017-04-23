package multi_thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arachis on 2017/4/23.
 */

public class NameList {
    private List nameList = Collections.synchronizedList(new LinkedList());

    public synchronized void add(String name) {
        nameList.add(name);
    }

    public synchronized String removeFirst() {
        if (nameList.size() > 0) {
            return (String) nameList.remove(0);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        final NameList nl = new NameList();
        nl.add("aaa");
        class NameDropper extends Thread{
            public void run(){
                String name = nl.removeFirst();
                System.out.println(name);
            }
        }

        Thread t1 = new NameDropper();
        Thread t2 = new NameDropper();
        t1.start();
        t2.start();
    }

}