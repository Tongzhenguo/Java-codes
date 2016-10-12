package OJ;

/**
 * Created by YYT on 2016/10/12.
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 *
 */

/**
 * 看大神的解法，理解了
 * 就是两数相加，等价于两个数和进位数的异或
 *
 * 那么关键就是进位数的求法
 * 而进位数是两个数的与并左移一位
 */
public class SumTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int c = a ^ b;
            b = (a & b) << 1;
            a = c;
        }
        return a;
    }
}
