import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;


/**
 * simhash算法的输入是一个向量（n维）,输出是一个 f 位的签名值,f<n,这其实是一种降维技术，将高维的向量用较低维度的签名来表征。
 *  simhash 算法如下：
 1，将一个 f 维的向量 V 初始化为 0 ； f 位的二进制数 S 初始化为 0 ；
 2，对每一个特征：用传统的 hash 算法对该特征产生一个 f 位的签名 b 。对 i=1 到 f ：
    如果b的第i位为1,则V的第i个元素加上该特征的权重；
    否则,V的第i个元素减去该特征的权重。
 3，如果 V 的第 i 个元素大于 0 ，则 S 的第 i 位为 1 ，否则为 0 ；
 4，输出 S 作为签名。

 *汉明距离计算相似度：
 这个算法相当于随机产生了f个n维超平面，每个超平面将向量v所在的空间一分为二，
 v在这个超平面上方则得到一个1，否则得到一个0，然后将得到的 f个0或1组合起来成为一个f维的签名。
 如果两个向量u, v的夹角为θ，则一个随机超平面将它们分开的概率为θ/π，因此u, v的签名的对应位不同的概率等于θ/π。
 所以，我们可以用两个向量的签名的不同的对应位的数量，即汉明距离，来衡量这两个向量的差异程度。

 * tips:根据经验值，对 64 位的 SimHash ，海明距离在 3 以内的可以认为相似度比较高。


 */
public class SimHash {

	private String tokens;

	private BigInteger intSimHash;

	private String strSimHash;

	private int hashbits = 64;

	public SimHash(String tokens) {
		this.tokens = tokens;
		this.intSimHash = this.simHash();
	}

	public SimHash(String tokens, int hashbits) {
		this.tokens = tokens;
		this.hashbits = hashbits;
		this.intSimHash = this.simHash();
	}

	HashMap wordMap = new HashMap();

	public BigInteger simHash() {
		// 定义特征向量/数组
		int[] v = new int[this.hashbits];
		// 1、将文本去掉格式后, 分词.
		StringTokenizer stringTokens = new StringTokenizer(this.tokens);
		while (stringTokens.hasMoreTokens()) {
			String temp = stringTokens.nextToken();
			// 2、将每一个分词hash为一组固定长度的数列.比如 64bit 的一个整数.
			BigInteger t = this.hash(temp);
			for (int i = 0; i < this.hashbits; i++) {
				BigInteger bitmask = new BigInteger("1").shiftLeft(i);
				// 3、建立一个长度为64的整数数组(假设要生成64位的数字指纹,也可以是其它数字),
				// 对每一个分词hash后的数列进行判断,如果是1000...01,那么数组的第一位和末尾一位加1,
				// 中间的62位减一,也就是说,逢1加1,逢0减1.一直到把所有的分词hash数列全部判断完毕.
				if (t.and(bitmask).signum() != 0) {
					// 这里是计算整个文档的所有特征的向量和
					// 这里实际使用中需要 +- 权重，而不是简单的 +1/-1，
					v[i] += 1;
				} else {
					v[i] -= 1;
				}
			}
		}
		BigInteger fingerprint = new BigInteger("0");
		StringBuffer simHashBuffer = new StringBuffer();
		for (int i = 0; i < this.hashbits; i++) {
			// 4、最后对数组进行判断,大于0的记为1,小于等于0的记为0,得到一个 64bit 的数字指纹/签名.
			if (v[i] >= 0) {
				fingerprint = fingerprint.add(new BigInteger("1").shiftLeft(i));
				simHashBuffer.append("1");
			} else {
				simHashBuffer.append("0");
			}
		}
		this.strSimHash = simHashBuffer.toString();
		System.out.println("strSimHash "+this.strSimHash + " length " + this.strSimHash.length());
		return fingerprint;
	}

    /**
     * 将每一个分词hash为一组固定长度的数列.比如 64bit 的一个整数.
     */
	private BigInteger hash(String source) {
		if (source == null || source.length() == 0) {
			return new BigInteger("0");
		} else {
			char[] sourceArray = source.toCharArray();
			BigInteger x = BigInteger.valueOf(((long) sourceArray[0]) << 7);
			BigInteger m = new BigInteger("1000003");
			BigInteger mask = new BigInteger("2").pow(this.hashbits).subtract(new BigInteger("1"));
			for (char item : sourceArray) {
				BigInteger temp = BigInteger.valueOf((long) item);
				x = x.multiply(m).xor(temp).and(mask);
			}
			x = x.xor(new BigInteger(String.valueOf(source.length())));
			if (x.equals(new BigInteger("-1"))) {
				x = new BigInteger("-2");
			}
			return x;
		}
	}

    /**
     * 计算汉明距离（定义：两个二进制码的不同位数，如011与101的汉明距离是2，因为1，2位不同）
     *  计算可以通过位的异或运算统计不同位的个数，异或原理：相同为0，不同为1
     */
	public int hammingDistance(SimHash other) {
        return this.intSimHash.xor(other.intSimHash).bitCount();
	}


	public List subByDistance(SimHash simHash, int distance) {
		// 分成几组来检查
		int numEach = this.hashbits / (distance + 1);
		List characters = new ArrayList();

		StringBuffer buffer = new StringBuffer();

		int k = 0;
		for (int i = 0; i < this.intSimHash.bitLength(); i++) {
			// 当且仅当设置了指定的位时，返回 true
			boolean sr = simHash.intSimHash.testBit(i);

			if (sr) {
				buffer.append("1");
			} else {
				buffer.append("0");
			}

			if ((i + 1) % numEach == 0) {
				// 将二进制转为BigInteger
				BigInteger eachValue = new BigInteger(buffer.toString(), 2);
				System.out.println("----eachValue " + eachValue);
				buffer.delete(0, buffer.length());
				characters.add(eachValue);
			}
		}

		return characters;
	}

	public static void main(String[] args) {
		String s = "This is a test string for testing";
		SimHash hash1 = new SimHash(s, 64);
		System.out.println("intSimHash " + hash1.intSimHash + "  " + "bitLength " + hash1.intSimHash.bitLength());
		hash1.subByDistance(hash1, 3);

        s = "This is a test string for testing, This is a test string for testing abcdef";
		SimHash hash2 = new SimHash(s, 64);
		System.out.println(hash2.intSimHash + "  " + hash2.intSimHash.bitCount());
		hash1.subByDistance(hash2, 3);

		System.out.println("============================");
		//计算汉明距离，距离越大，相似度越低
		System.out.println("hammingDistance "+hash1.hammingDistance(hash2));

	}
}