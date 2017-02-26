import java.io.InputStream;
import java.security.MessageDigest;

public class MD5Util {
	

	private static final char HEX_DIGITS[] =
			{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    protected static String byte16to32(byte[] byte16) {
        char str[] = new char[16 * 2];
        int k = 0;
        for (int i = 0; i < 16; i++) {
            byte byte0 = byte16[i];
            str[k++] = HEX_DIGITS[byte0 >>> 4 & 0xf];
            str[k++] = HEX_DIGITS[byte0 & 0xf];
        }
        return new String(str);
    }

	public static String md5(String text) {
		String result = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(text.getBytes("UTF-8"));
			byte[] b = md5.digest();
			result = byte16to32(b);
		} catch (Exception e) {
			// do nothing
		}
		return result;
	}

	public static String md5(byte[] bytes) {
		String result = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(bytes);
			byte[] b = md5.digest();
			result = byte16to32(b);
		} catch (Exception e) {
			// do nothing
		}
		return result;
	}

    public static void main(String[] args) {

        String[] list1 = {"《数学之美》读后感| 忆桐之家的博客","数学之美读书笔记（四） - 程序园","《数学之美》的笔记-全书 - 豆瓣读书"};
        String[] list2 = {"《数学之美》的笔记-全书 - 豆瓣读书","数学之美读书笔记（四） - 程序园","《数学之美》读后感| 忆桐之家的博客"};
        int res1 = 0;int res2 = 0;
        for(int i=0;i<3;i++){
            String n1 = MD5Util.md5(list1[i]);
            System.out.println(n1);
            String n2 = MD5Util.md5(list2[i]);
            System.out.println(n2);
            res1 += n1.hashCode();res2 += n2.hashCode();
        }
        System.out.println(res1 - res2);
    }

}
