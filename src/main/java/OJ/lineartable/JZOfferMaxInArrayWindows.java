package OJ.lineartable;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferMaxInArrayWindows {

    // 定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
    // 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
    // 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
    //  {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
    //  {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        int initialCapacity = num.length - size + 1;
        if(initialCapacity <= 0 || size <= 0){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList<Integer>(initialCapacity);
        //最大堆实现，复杂度O(nlogn)
        // 用大顶堆实现,初始化第一个滑动窗口
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(size, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        for(int i=0;i<size;i++){
            queue.add(num[i]);
        }
        list.add(queue.peek());
        for(int i=0;i<initialCapacity-1;i++){
            // 滑动到下一个窗口
            queue.remove(num[i]);
            queue.add(num[i+size]);
            list.add(queue.peek());
        }

        return list;
    }


    public static void main(String[] args) {
        int[] a = {2,3,4,2,6,2,5,1};
        for(int i:new JZOfferMaxInArrayWindows().maxInWindows(a,3)){
            System.out.println(i);
        }

    }

}
