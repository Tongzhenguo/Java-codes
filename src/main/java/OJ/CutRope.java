package OJ;

/**
 * Created by tongzhenguo on 2019/11/6.
 */
public class CutRope {

    // 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
    // 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
    // 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

    // 输入一个数n，意义见题面。（2 <= n <= 60）
    public int cutRope(int target) {
        // 贪婪算法：尽可能多的剪成长度为3的绳子，如果最后余4就剪成2,2
        // 数学描述：当n≥5时，3(n−3)≥2(n−2)恒成立
        if(target<3){
            return target - 1;
        }
        int timesOf3 = target % 3 == 1 ? (target / 3 - 1) : target / 3;
        int timesOf2 = (target - timesOf3 * 3) / 2;
        return (int)(Math.pow(3,timesOf3) * Math.pow(2,timesOf2));
    }

    public static void main(String[] args) {
        System.out.println(new CutRope().cutRope(8));

    }

}
