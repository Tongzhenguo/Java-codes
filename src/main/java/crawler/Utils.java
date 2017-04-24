/*
package crawler;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Utils {

	*/
/*
	 * �ַ���˱����
	 *//*

	public static String replaceSpecStr(String orgStr) {
		if (null != orgStr && !"".equals(orgStr.trim())) {
			String regEx = "[\\s~��`!��@#��$%^����&*��()��\\-����\\-_=+��\\[\\]����{}��\\|��\\\\��;��:��'����\"��,��<��.��>��/��?]";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(orgStr);
			return m.replaceAll("");
		}
		return null;
	}

	*/
/*
	 * �ַ��п�
	 *//*


	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	*/
/*
	 * �����ַ��ȡԴ���룬��ת��xml�ļ�
	 *//*


	public static Document getDocument(String url) {
		try {
			return Jsoup.connect(url).get();
		} catch (IOException e) {
			System.out.println("�˸�����Ϻ�������в����ڣ������");
		}
		return null;
	}
}

*/
