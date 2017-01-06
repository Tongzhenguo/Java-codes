package OJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arachis on 2017/1/3.
 *
 * 题目大意：
 *一个二进制手表顶端有4盏LED灯表示小时(0-11)，底部有6盏LED灯表示分钟(0-59)。
* 每一盏LED灯表示一个0或1，最右端为最低位。

*给定一个非负整数n表示当前燃亮的LED灯数，返回所有可能表示的时间。
 */
public class BinaryWatch {
    /*
    *  get到一个易理解的方法
    *   遍历所有的小时和分钟表示，转化为二进制位表示，
    *   如果符合需求就添加到结果列表中
    *
    *   这里java 更底层一点吧，注意String.format的空缺是空格填充的
    *   另外还有Integer.bitcount的使用，及源码
    */
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        for(int h=0;h<12;h++){
            for(int m=0;m<60;m++){
                if(Integer.bitCount(h)+Integer.bitCount(m) == num){
                    res.add(String.format("%d:%2d",h,m).replaceAll(" ","0"));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> strings = new BinaryWatch().readBinaryWatch(3);
        for(String s:strings){
            System.out.println(s);
        }
    }

}
