package OJ;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Tongzhenguo on 2017/5/16.
 *
 Given a string, find the length of the longest substring without repeating characters.
找到含有最多不重复字符的最长字串，返回长度
 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Longest_Substring_Without_Repeating_Characters {
    /**
     * the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values,
     * and keep two pointers which define the max substring. move the right pointer to scan through the string ,
     * and meanwhile update the hashmap. If the character is already in the hashmap,
     * then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.
     * */
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                //移动左指针到现在重复字符出现的位置
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println( new Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring("dvdf") );
    }

}
