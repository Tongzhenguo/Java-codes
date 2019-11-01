package OJ;

/**
 * Created by tongzhenguo on 2019/11/1.
 */
public class Regular_Expression_Matching {

    /**
     *
     * 1.牛客网的输入为字符数组形式&递归解法
     * https://www.nowcoder.com/profile/377294978/codeBookDetail?submissionId=60683917
     *
     * 用 T 和 P 分别表示匹配串和模式串的长度。
     * 时间复杂度为 O((T+P)2^{T + \frac{P}{2}})
     * 空间复杂度为 O((T+P)2^{T + \frac{P}{2}})
     */

    // 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
    // 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
    // 在本题中，匹配是指字符串的所有字符匹配整个模式。
    // 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }


    public boolean matchCore(char[] str, int s, char[] pattern, int p) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if(p == pattern.length){
            // pattern先到尾，匹配失败
            return s == str.length;
        }
        //模式第2个是*
        if (p + 1 < pattern.length && pattern[p + 1] == '*') {
            if ( s != str.length && (pattern[p] == str[s] || pattern[p] == '.') ) {
                //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式
                return matchCore(str, s, pattern, p + 2)                //模式后移2，视为x*匹配0个字符
                        || matchCore(str, s + 1, pattern, p + 2)     //视为模式匹配1个字符
                        || matchCore(str, s + 1, pattern, p);           //*匹配1个，再匹配str中的下一个
            } else {
                //模式第2个是*，且字符串第1个跟模式第1个不匹配，模式后移2位
                return matchCore(str, s, pattern, p + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ( s != str.length && (pattern[p] == str[s] || pattern[p] == '.')) {
            return matchCore(str, s + 1, pattern, p + 1);
        }
        return false;
    }


    /**
     *
     * 2.力扣(LeetCode)的输入为字符串形式&动态规划解法
     * https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/
     * https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode/
     *
     * 用 T 和 P 分别表示匹配串和模式串的长度。
     * 时间复杂度为 O(TP)
     * 空间复杂度为 O(TP)
     */

    public boolean isMatch(String text, String pattern) {
        // 状态dp[i][j] 表示text[i:] 和 pattern[j:] 是否能匹配
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;
        // 自底向上的方法
        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length()
                        && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }

}
