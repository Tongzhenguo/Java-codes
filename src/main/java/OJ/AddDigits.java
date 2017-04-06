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
    /**
     * 我的方法：使用了while判断终止和for进行相加，O(n)复杂度
     * @param num
     * @return
     */
    /*public int addDigits(int num) {
        byte[] digits = ("" + num).getBytes();
        while (digits.length !=1){
            int sum = 0;
            for(int i=0;i<digits.length;i++){
                sum +=digits[i]-'0';
            }
            digits = ("" + sum).getBytes();
        }
        return digits[0]-'0';
    }*/

    /**
     * 查看百度百科之后，这是数（字）根的原始问题
     * 有如下公式 b=(a-1)%9 +１，其中ａ是自然数，b是a的数字根
     * @param num
     * @return
     */
    public int addDigits(int num){
        //return (num-1)%9+1;
        /**树根的两条性质
         * 1.任何数加9的数字根还是它本身
         * 2.9乘任何数字的数字根都是9。
         * 可以将b=(num-1)%9+1这个公式看作这两个性质的总结吧
         *
         */
        if(num==0){
            return 0;
        }else {
            return num%9 ==0?9:num%9;
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
