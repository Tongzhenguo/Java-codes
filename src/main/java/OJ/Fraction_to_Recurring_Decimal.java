package OJ;

import java.util.HashMap;

/**
 * Created by Tongzhenguo on 2017/5/9.
 *
 Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 给定分子和分母，返回这个分式的值对应的字符串，如果值是循环的，用括号括住循环的部分
 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class Fraction_to_Recurring_Decimal {
    /**
     * Use HashMap to store a remainder and its associated index
     * while doing the division so that whenever a same remainder comes up, we know there is a repeating fractional part.
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {//不断循环，map判断是不是循环
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }




}
