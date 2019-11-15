package OJ.pattrenmatch;


/**
 * Created by tongzhenguo on 2019/10/9.
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但是与"aa.a"和"ab*a"均不匹配
 */


public class JZOfferRegexIsNumeric {

    public boolean isNumeric1(char[] str) {
        String string = String.valueOf(str);
//        以下对正则进行解释:
//        [\\+\\-]?            -> 正或负符号出现与否
//        \\d*                 -> 整数部分是否出现，如-.34
//        (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
//                                否则一起不出现
//        ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
//                                紧接着必须跟着整数；或者整个部分都不出现
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }

    // 时间复杂度O(N),空间复杂度O(1)
    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str.length < 1)
            return false;
        // 整数部分是否出现
        boolean flag = scanInteger(str);
        // 如果出现小数点，那么小数点后面必须有数字
        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }
        // 如果存在指数部分，那么e或E肯定出现，+或-可以不出现,紧接着必须跟着整数；或者整个部分都不出现
        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && (index == str.length);

    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-') )
            index++;
        return scanUnsignedInteger(str);

    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return start < index; //是否存在整数
    }


    public static void main(String[] args) {
        char[] c = {'0','1'};
        System.out.println(new JZOfferRegexIsNumeric().isNumeric(c));
    }

}
