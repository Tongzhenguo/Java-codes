package OJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNumber {
    // 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    // 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

    // 链接：https://www.nowcoder.com/questionTerminal/8fecd3f8ba334add803bf2a06af1b993?f=discussion
    // 来源：牛客网
    public String PrintMinNumber(int [] numbers) {
        int n;
        String s="";
        ArrayList<Integer> list= new ArrayList<Integer>();
        n=numbers.length;
        for(int i=0;i<n;i++){
            list.add(numbers[i]);

        }
        Collections.sort(list, new Comparator<Integer>(){
//            作者：fantasy_
//            链接：https://www.nowcoder.com/questionTerminal/8fecd3f8ba334add803bf2a06af1b993?f=discussion
//            来源：牛客网
//            关于比较器，比如例题中的{3，32，321} 数组中先放入3，而后3和32比较，因为332>323 所以3>32 数组此时为[32,3];
// 再往数组中加入321，先与32比较，32132<32321 故 321<32  故321应排在32前面，再与3比较 3213<3321 故321<3 数组最终排序[321，32，3]
            public int compare(Integer str1,Integer str2){
                String s1=str1+""+str2;
                String s2=str2+""+str1;
                return s1.compareTo(s2);
            }
        });

        for(int j:list){
            s+=j;
        }
        return s;
    }

    public static void main(String[] args) {
        PrintMinNumber o = new PrintMinNumber();
        int[] sequence = {3,32,321};
        System.out.println("332".compareTo(""));
        System.out.println(o.PrintMinNumber(sequence));
    }
}