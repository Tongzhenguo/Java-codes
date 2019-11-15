package OJ.math;


/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferTwoSum {

    // 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
    public int Add(int num1,int num2) {
        // (1)不考虑进位：二进制每位相加就相当于各位做异或操作
        // (2)计算进位值：相当于各位做与操作得到，再向左移一位
        // (3)继续重复上述两步;进位值为0，跳出循环

        // 为节省空间，计算进位的变量复用num2，不考虑进位结果变量复用num1
        if(num1 == 0){return num2;}
        if(num2 == 0){return num1;}

        while (num2 != 0){
            int tmp = num1 ^ num2;
            num2 = (num1 & num2)<<1;
            num1 = tmp;
        }
        return num1;
    }


    public static void main(String[] args) {
        System.out.println(new JZOfferTwoSum().Add(10,4));
    }

}
