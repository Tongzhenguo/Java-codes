package OJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYT on 2016/10/17.
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 *For example:

 *Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 *Follow up:
 *Could you do it without any loop/recursion in O(1) runtime?
 * 简单的说就是给你一个非负整数，重复相加所有位上的数字，知道结果为一位数字返回。
 * 例如：num = 38,3+8=11,1+1=2
 * 是否可以实现O(1)的算法？
 */
public class AddDigits {

    public int addDigits(int num){
        /**数字根的两条性质
         * 1.任何数加9的数字根还是它本身
         * 2.9乘任何数字的数字根都是9。
         * 可以将b=num%9这个公式看作这两个性质的总结吧
         *  证明 :
         *    a = 9k + b,由性质2得：a的树根为9+b;再由性质1知道a的数字根就是b
         */
        if(num==0){
            return 0;
        }else {
            return num%9==0?9:num%9;
        }
    }

    public static void main(String[] args) {

        final List<String> ageRanges = new ArrayList<String>(8){{
            add("1-14");add("15-19");add("20-24");
            add("25-29");add("30-34");add("35-39");
            add("40-44");add("45-100");
        }};

        System.out.println(ageRanges.get( Integer.parseInt("8.0".substring(0, 1)) ));;

       /* AddDigits o = new AddDigits();

        System.out.println(o.addDigits(100));
       *//* System.out.println(Integer.MAX_VALUE);*/
    }
}
