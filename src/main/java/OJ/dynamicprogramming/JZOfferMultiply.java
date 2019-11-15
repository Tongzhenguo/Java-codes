package OJ.dynamicprogramming;


/**
 * Created by tongzhenguo on 2019/10/9.
 */

public class JZOfferMultiply {

    // 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
    // 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
    public int[] multiply(int[] A) {

        //B[i]的值可以看作下图的矩阵中每行的乘积。
        //下三角用连乘可以很容求得，上三角，从下向上也是连乘。
        //因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。

        //note(披萨大叔) 因为上一步只影响下一步(动态规划)，所以上下三角中的累乘部分无需数组存储，可以使用临时变量节省内存复杂度
        int[] B = new int[A.length];
        if(A.length == 0){
            return B;
        }
        // 计算下三角累乘和B[i]的一半
        B[0] = 1;
        for(int i=1;i<A.length;i++){
            B[i] = B[i-1]*A[i-1];
        }
        // 计算上三角累乘和B[i]最终结果
        int tmp = 1;
        for(int i=A.length-2;i>=0;i--){
            tmp *= A[i+1];
            B[i] *= tmp;
        }
        return B;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = new JZOfferMultiply().multiply(a);
        for(int x:b){
            System.out.println(x);
        }
    }

}
