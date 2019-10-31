package OJ;

/**
 * Created by Tongzhenguo on 2017/6/7.

 We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。

 Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False

 Example:
 Input: 28
 Output: True
 Explanation: 28 = 1 + 2 + 4 + 7 + 14

 提示：输入的数字 n 不会超过 100,000,000. (1e8)
 *
 */
public class Perfect_Number {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;

        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) { //除数
            if (num % i == 0) {
                sum += i;
                if (i != num / i) //商
                    sum += num / i;
            }
        }

        return sum == num;
    }

}
