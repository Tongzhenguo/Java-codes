package OJ.math;

/**
 * Created by tongzhenguo on 2019/11/14.
 */
public class JZOfferNumberOf1Between1AndN {

    // 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
    // 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
    // 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
    // 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
    public int NumberOf1Between1AndN_Solution(int n) {
        // 咩咩jiang
        int count=0;
        long i=1;
        // 设定整数点（如1、10、100等等）作为位置点i（对应n的各位、十位、百位等等），分别对每个数位上有多少包含1的点进行分析
        for(i=1;i<=n;i*=10)
        {
            //i表示当前分析的是哪一个数位
            // 如n=31156,i=100，则a=311,b=56
            // 当百位对应0或>=2时，有(a+8)/10次包含所有100个点，还有当百位为1(a%10==1)，需要增加局部点b+1
            long a = n/i,b = n%i;
            // 之所以补8，是因为当百位为0，则a/10==(a+8)/10，当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count+=(a+8)/10*i+(a%10==1?1:0)*(b+1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new JZOfferNumberOf1Between1AndN().NumberOf1Between1AndN_Solution(10));
        System.out.println(new JZOfferNumberOf1Between1AndN().NumberOf1Between1AndN_Solution(13));
        System.out.println(new JZOfferNumberOf1Between1AndN().NumberOf1Between1AndN_Solution(100));
        System.out.println(new JZOfferNumberOf1Between1AndN().NumberOf1Between1AndN_Solution(1000));

    }
}
