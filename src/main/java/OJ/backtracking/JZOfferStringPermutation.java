package OJ.backtracking;

import java.util.*;

/**
 * Created by tongzhenguo on 2019/11/14.
 */
public class JZOfferStringPermutation {

    // 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
    // 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

    // 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if(str!=null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }
    void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        if(i == chars.length-1){
            list.add(String.valueOf(chars));
        }else{
            ArrayList<Character> charSet = new ArrayList<Character>();
            for(int j=i;j<chars.length;++j){
                // 去重的全排列就是从第一个数字起，每个数分别与它后面非重复出现的数字交换。
                if(j==i || !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i+1,list);
                    // 第二个swap用以使得字符数组的顺序回到进入递归前的状态，这样才不会影响外部的遍历顺序。
                    swap(chars,j,i);
                }
            }
        }
    }
    void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }


    public static void main(String[] args) {
        System.out.println(new JZOfferStringPermutation().Permutation("abc"));
    }
}
