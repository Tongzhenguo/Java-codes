package OJ;

/**
 * Created by Tongzhenguo on 2017/6/13.
 Write a program to find the nth super ugly number.
 编写一段程序来查找第 n 个超级丑数。

 Super ugly numbers are positive numbers　whose all prime factors are in the given prime list primes of size k.
 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 For example, [1, 2, ４, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

 示例:
 输入: n = 12, primes = [2,7,13,19]
 输出: 32
 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。


 Note:
 (1) 1 is a super ugly number for any given primes.
 (2) The given numbers in primes are in ascending order.
 (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

 说明:
 (1) 1 是任何给定 primes 的超级丑数。
 (2) 给定 primes 中的数字以升序排列。
 (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 (4) 第 n 个超级丑数确保在 32 位有符整数范围内。

 */
public class Super_Ugly_Number {

    public int nthSuperUglyNumberI(int n, int[] primes) {
        // 时间复杂度O(NM),m是给定质数列表长度，n是参数第那个丑数
        int[] ugly = new int[n];
        // note(核心数据结构) 下标对应primes每个质数，值对应超级丑数数组的指针
        int[] idx = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            // 第一个循环用来计算第i个超级丑数
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++){
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
            }
            // 第二个循环用来设置
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[idx[j]] <= ugly[i]){
                    idx[j]+=1;
                }
            }
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {

        Super_Ugly_Number super_ugly_number = new Super_Ugly_Number();
        for(int i=1;i<12;i++ ){
            super_ugly_number.nthSuperUglyNumberI(i,new int[]{2, 7, 13, 19} );
        }


    }

}
