package OJ;

/**
 * Created by Tongzhenguo on 2017/6/23.
 * Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class Integer_to_Roman {
  public String intToRoman(int num) {
      String M[] = {"", "M", "MM", "MMM"};
      String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
      String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
      String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
      return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];

   }
}
