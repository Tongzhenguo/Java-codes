package OJ;

import java.util.Stack;

/**
 * Created by Administrator on 2016/10/15.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *简单的说就是有大中小三种括号,封闭的就验证有效
 *  例：有效{[()]}
 *      无效([)
 */
public class ValidParentheses {
    public boolean isParentheses(char s,char t){
        String str = "" + s + t;
        return "()".equals(str) || "[]".equals(str) || "{}".equals(str);
    }
    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<Character>();
        char[] bracks = s.toCharArray();
        for(char brack:bracks){
            if(!bracketStack.empty() && isParentheses(bracketStack.peek(),brack)){
                bracketStack.pop();
            }else{
                bracketStack.push(brack);
            }
        }
        return bracketStack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("{[()()]}"));
        System.out.println(vp.isValid("{[)"));
    }
}
