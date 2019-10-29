package OJ;

/**
 * Created by Tongzhenguo on 2017/6/8.
 *
 You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available.
 You need to determine whether it is possible to measure exactly z litres using these two jugs.
 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？

 If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。


 Operations allowed:
 Fill any of the jugs completely with water.
 Empty any of the jugs.
 Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.

 你允许：
 装满任意一个水壶
 清空任意一个水壶
 从一个水壶向另外一个水壶倒水，直到装满或者倒空

 Example 1: (From the famous "Die Hard" example)
 Input: x = 3, y = 5, z = 4
 Output: True

 Example 2:
 Input: x = 2, y = 6, z = 5
 Output: False


 */
public class Water_and_Jug_Problem {
    /**
     *
     - [裴蜀定理](https://baike.baidu.com/item/%E8%A3%B4%E8%9C%80%E5%AE%9A%E7%90%86/5186593?fr=aladdin)

     */

    public boolean canMeasureWater(int x, int y, int z) {
        // 两个水壶都倒满也得不到所求
        if(x + y < z) return false;
        if( x == z || y == z || x + y == z ) return true;
        // 裴蜀定理：x,y不全为0时，一定存在整数a,b;使得ax+by % gcd(x,y) = 0;
        return z%GCD(x, y) == 0;
    }

    // 欧几里得算法
    public int GCD(int a, int b){
        while(b != 0 ){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

}
