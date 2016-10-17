package OJ;

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
        //任何数加9的数字根还是它本身。
        return num%9;
    }

    public static void main(String[] args) {
        AddDigits o = new AddDigits();
        /*System.out.println(o.addDigits(38));
        System.out.println(o.addDigits(3829));*/
        //System.out.println(o.addDigits(100));
        System.out.println(o.addDigits(708538619));
       /* System.out.println(Integer.MAX_VALUE);*/
    }
}
