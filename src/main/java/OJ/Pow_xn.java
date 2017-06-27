package OJ;

/**
 * Created by Tongzhenguo on 2017/6/27.
 * Implement pow(x, n). n是整数
 */
public class Pow_xn {
    public double myPow(double x, int n) {
        if(x==1)
            return 1;
        if(n == 0)
            return 1;
        if(n<0){
            if( n== Integer.MIN_VALUE  ) //java -2147483648取负还是-2147483648
                n = Integer.MAX_VALUE-1;
            else
                n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x * x,n / 2) : x*myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(new Pow_xn().myPow(-1.00000, -2147483648));;

    }

}
