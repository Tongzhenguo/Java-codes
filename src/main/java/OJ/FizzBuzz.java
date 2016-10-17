package OJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/16.
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 *But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 *For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 *简单的说就是输出1到n的数列，如果是3的倍数，输出Fizz,5的倍数输出Buzz，结果是一个列表
 */

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> strList = new ArrayList<String>(n);
        for(int i=1;i<=n;i++){
            StringBuilder strBuilder = new StringBuilder();
            if(i%3 == 0){
                strBuilder.append("Fizz");
            }
            if(i%5 == 0){
                strBuilder.append("Buzz");
            }
            if(i%3 != 0 && i%5 != 0){
                strBuilder.append(i);
            }
            strList.add(strBuilder.toString());
        }
        return strList;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(15));
    }
}
