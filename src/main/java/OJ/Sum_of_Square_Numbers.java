package OJ;

/**
 * Created by Tongzhenguo on 2017/7/3.
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a^2 + b^2 = c.

 Example 1:
 Input: 5
 Output: True
 Explanation: 1 * 1 + 2 * 2 = 5
 Example 2:
 Input: 3
 Output: False
 */
public class Sum_of_Square_Numbers {
    public static boolean judgeSquareSum(int c) {
        for (int i=0;i<=Math.sqrt(c);i++)
            if (Math.floor(Math.sqrt(c-i*i)) == Math.sqrt(c-i*i)) return true;
        return false;
    }
}
