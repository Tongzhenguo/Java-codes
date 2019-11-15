package OJ.tree;


import java.util.TreeSet;

/**
 * Created by tongzhenguo on 2019/10/9.
 *
 */


public class JZOfferDataStreamMedian {

    // 如何得到一个数据流中的中位数？
    // 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
    // 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
    // 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。

    TreeSet<Integer> set = new TreeSet<Integer>();

    public void Insert(Integer num) {
        // 插入logn
        // 红黑树在频繁增或删的情况下无需像AVL一样频繁调整
        set.add(num);
    }

    public Double GetMedian() {
        // 查询O(1)
        Integer[] array = set.toArray(new Integer[set.size()]);
        return array.length%2==1?(double)array[array.length/2]:(array[array.length/2-1]+array[array.length/2])/2.0;
    }

    public static void main(String[] args) {
        JZOfferDataStreamMedian o = new JZOfferDataStreamMedian();
        int[] array = {5,2,3,4,1,6,7,0,8};
        for (int i: array) {
            o.Insert(i);
            System.out.println(""+o.set+","+o.GetMedian());
        }
    }

}
