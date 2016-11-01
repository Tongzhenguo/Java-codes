package OJ;

/**
 * Created by YYT on 2016/11/1.
 *Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 简单的说就是A-Z 26进制数转换十进制数的问题
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int pow = 26;
        int sum = 0;
        int i = 0;//num of power
        while (i<chars.length){ //from right to left
            int num = chars[chars.length-1-i] - 'A' + 1;//char to int
            sum += num * Math.pow(pow,i);
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber o = new ExcelSheetColumnNumber();
        System.out.println(o.titleToNumber("AB"));
        System.out.println(o.titleToNumber("B"));
    }
}
