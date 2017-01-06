import java.math.BigInteger;

/**
 * Created by arachis on 2017/1/6.
 *
 * BigInteger.bitCount的一个实现
 */
public class BitCount {
    /**
     * 统计x中二进制位数为1的个数
      我们想想，一个二进制数减去1，那么，从最后那个1（包括那个1）后面的数字全都反了，对吧，然后，n&(n-1)就相当于把后面的数字清0，
      我们看n能做多少次这样的操作就OK了。
     */
    public static int bitCount(BigInteger x){
        int tot = 0;
		while (x.signum() != 0) {
			tot += 1;
			x = x.and(x.subtract(new BigInteger("1")));
		}
		return tot;
    }

    public static void main(String[] args) {
        System.out.println(bitCount(new BigInteger("123", 10)));
    }

}
