package OJ;

/**
 * Created by Tongzhenguo on 2017/6/12.
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

 Example:
 Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
public class Count_Numbers_with_Unique_Digits {
    /*
    *  Let f(n) = count of number with unique digits of length n.
    f(1) = 10. (0, 1, 2, 3, ...., 9)
    f(2) = 9 * 9. Because for each number i from 1, ..., 9, we can pick j to form a 2-digit number ij and there are 9 numbers that are different from i for j to choose from.
    f(3) = f(2) * 8 = 9 * 9 * 8.
    Similarly f(4) = f(3) * 7 = 9 * 9 * 8 * 7....
    ...
    f(10) = 9 * 9 * 8 * 7 * 6 * ... * 1
    f(11) = 0 = f(12) = f(13)....
    any number with length > 10 couldn't be unique digits number.
    The problem is asking for numbers from 0 to 10^n. Hence return f(1) + f(2) + .. + f(n)
    * */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)     return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        //res(n) = f(1) + f(2) + .. + f(n)
        while (n > 1 && availableNumber > 0) {
            uniqueDigits *=  availableNumber;
            res += uniqueDigits;
            availableNumber-=1;
            n -= 1;
        }
        return res;
    }

}
