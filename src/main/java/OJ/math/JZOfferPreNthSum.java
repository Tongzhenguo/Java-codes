package OJ.math;


/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferPreNthSum {

    // 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    public int Sum_Solution(int n) {
        // f(n) = n(n+1)/2
        // 利用短路 && 来实现 if的功能；二，利用递归来实现循环while的功能
        // /2使用右移位
        // n(n+1) = (n << e0) + (n << e1) + ...,其中e0,e1是2的权值2^i,可以用a,b两个变量分别右移和左移进行代替
        int res = multi(n, n + 1);//n*(n-1)
        return res>>=1;//n*(n-1)/2
    }


    private int multi(int a, int b) {
        int res = 0;
        //循环体内部, if ((a & 1) == 1), res += b;
        boolean flag1 = ((a & 1) == 1) && (res += b) > 0;
        a >>= 1;
        b <<= 1;
        // while (a != 0) {}循环条件
        boolean flag2 = (a != 0) && (res += multi(a,b)) > 0 ;
        return res;
    }


    public static void main(String[] args) {
//        System.out.println(new JZOfferPreNthSum().LastRemaining_Solution(10,4));
    }

}
