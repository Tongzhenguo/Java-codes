package OJ;

/**
 * Created by Tongzhenguo on 2017/6/7.
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

 Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 Example:
 Input: 28
 Output: True
 Explanation: 28 = 1 + 2 + 4 + 7 + 14
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
