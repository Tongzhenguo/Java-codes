package OJ;

/**
 * Created by Administrator on 2016/10/11.
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * 　晓东分析：
 *　　这个题目的关键在于线性的复杂度，这不由得让我们去想别的都是出现两次这样的条件。
 *    我们开始想，把这些一样都减掉不就只剩那个出现过一次的元素了？可惜我们无法实现那个把他们都减掉的算法
 *    没关系，我们突然想到了一个更好的方法，就是相同的数除了相减还有一种方法结果为0，那就是异或。
 *    这样的话，因为相同的元素都被异或为0了，而任何数和0异或结果还是它本身，
 *    所以我们把所有的元素都一起异或，不就剩了那个单独的元素了么？
 */
public class SingleNumber {
    class Solution {
        public int singleNumber(int A[], int n) {
            // Note: The Solution object is instantiated only once and is reused by each test case.
            int result = A[0];
            if(n == 1)
                return result;
            for(int i = 1; i < n; i++)
                result ^= A[i];
            return result;
        }
    }
}
