package OJ;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by arachis on 2017/10/5.
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class Largest_Number {
    //迭代地比较相邻两个字符串，决定（s1+s2）还是（s2+s1）
    public String largestNumber(int[] num) {
        if(num == null || num.length == 0)
            return "";

        // Convert int array to String array, so we can sort later on
        String[] s_num = new String[num.length];
        for(int i = 0; i < num.length; i++)
            s_num[i] = String.valueOf(num[i]);

        // Comparator to decide which string should come first in concatenation
        Comparator<String> stringComparator = (str1, str2) -> (str2 + str1).compareTo(str1 + str2);
        Arrays.sort(s_num, stringComparator); //sort desc reverse = True
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(s_num[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s: s_num)
            sb.append(s);

        return sb.toString();

    }

}
