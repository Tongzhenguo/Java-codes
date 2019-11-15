package OJ.hashtable;


import java.util.ArrayList;

/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferCharStreamFirstOne {

    // 请实现一个函数用来找出字符流中第一个只出现一次的字符。
    // 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
    // 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

    // 如果当前字符流没有存在出现一次的字符，返回#字符。


    // 时间复杂度O(1),空间复杂度O(n)
    // 一个字符占8位，因此不会超过256个，可以申请一个256大小的数组来实现一个简易的哈希表,统计每个字符出现的次数。
    int[] counterMap = new int[256];

    // 用一个列表记录候选字符，插入时如果第一次遇到ch字符，则进入候选列表，否则删除。
    ArrayList<Character> list=new ArrayList<Character>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        counterMap[ch] += 1;
        // 第一个只出现一次的字符
        if(counterMap[ch] == 1){
            list.add(ch);
        }else{
            list.remove((Character) ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return list.size()>0?list.get(0):'#';
    }

    public static void main(String[] args) {
        String s = "BabyBaby";
        // ggg#ll
        // go##le
        JZOfferCharStreamFirstOne JZOfferCharStreamFirstOne = new JZOfferCharStreamFirstOne();
        for (char c :s.toCharArray()) {
            JZOfferCharStreamFirstOne.Insert(c);
            System.out.println(JZOfferCharStreamFirstOne.FirstAppearingOnce());
        }

    }

}
