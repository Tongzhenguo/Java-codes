package OJ;

/**
 * Created by Tongzhenguo on 2017/6/26.
 * Your task is to calculate a^b mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。

 Example1:
 a = 2
 b = [3]
 Result: 8

 Example2:
 a = 2
 b = [1,0]
 Result: 1024

 */
public class Super_Pow {

    public int superPow(int a, int[] b) {
        // 求出欧拉函数的值
        int c=ol(1337);
        int sum=0;
        // 根据欧拉定理，如果b远大于c,则有$a^b % 1337 = a^{ b mod c + c} % 1337$
        for(int i=0;i<b.length;i++){
            // 计算b mod c
            sum = ( sum * 10 + b[i] ) % c;
        }
        sum += c;
        return pow_mod((long)a,sum,1337);
    }

    // 计算x^ mod M
    // 注意：根据费马小定理，如果M是一个质数，我们可以计算x^{n mod (m-1)}来加速算法过程。
    private int pow_mod(long x,int y,int M) {
        long res=1;
        while(y>0) {
            if( y % 2 > 0 ){
                // 取余不会干预乘法
                res = res * x % M;
            }
            // 快速幂
            x = x * x % M;
            y /= 2;
        }
        return (int)res;
    }

    // 求解x的欧拉函数，即小于等于n和n互质的数的个数
    // 计算公式：$\varphi(n) = n * \prod_{i = 1}^s{\frac{p_i - 1}{p_i}}$
    private int ol(int x) {
     int res=x;
     for(int i=2;i*i<=x;i++) {
         if(x%i==0) {
            res=res-res/i;
            while(x%i==0)
                x/=i;
         }
     }
     if(x>1) res=res-res/x;
     return res;
   }

    public static void main(String[] args) {
        for(int i=2;i*i<=1337;i++){
            if(1337 % i == 0)
                System.out.println(i);
        }
    }
}
