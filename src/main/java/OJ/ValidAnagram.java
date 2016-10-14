package OJ;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YYT on 2016/10/14.
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 大概意思就是：判断两个字符串是不是易位得到的，假定都是小写字母
 *
 */
public class ValidAnagram {
    //O(n) O(n)
    public boolean isAnagram(String s, String t) {
        Map<Byte,Integer> bytescount = new HashMap<Byte,Integer>();
        for(Byte by:s.getBytes()){
            if(bytescount.containsKey(by)){
                bytescount.put(by,bytescount.get(by)+1);
            }else {
                bytescount.put(by,1);
            }
        }
        for(Byte by:t.getBytes()){
            if(bytescount.containsKey(by)){
                bytescount.put(by,bytescount.get(by)-1);
                if(0 ==bytescount.get(by)){
                    bytescount.remove(by);
                }
            }else {
                return false;
            }
        }
        return bytescount.size() == 0;
    }

    public static void main(String[] args) {
        ValidAnagram valid = new ValidAnagram();
        System.out.println(valid.isAnagram("aaa", "aa"));
        System.out.println(valid.isAnagram("anagram", "nagaram"));
        System.out.println(valid.isAnagram("rat", "car"));
    }

}
