package OJ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tongzhenguo on 2017/5/10.
 *
 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 nucleotides abbreviated:核苷酸,使用大写字母A-Z表示
 设计算法，找到所有长度为10的，并且出现不止一次的子序列
 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class Repeated_DNA_Sequences {
    /**
     v = v | (s.charAt(j) - 'A'); - does it really work?

     My assumption is that it is going to produce random results, since:

     'C' - 'A' = 2 (10 in binary)
     'G' - 'A' = 6 (110)
     'T' - 'A' = 19 (10011)

     With bitwise "OR" this is going to produce chaotic values.
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        List<String> rv = new ArrayList<>();//重复出现的序列
        char[] map = new char[26];
        //map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;// 'C' - 'A' = 2 (10 in binary)
        map['G' - 'A'] = 2;// 'G' - 'A' = 6 (110)
        map['T' - 'A'] = 3;// 'T' - 'A' = 19 (10011)

        for(int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for(int j = i; j < i + 10; j++) {
                v = v << 2;//v * 4
                v = v | map[s.charAt(j) - 'A'];// v = v | (s.charAt(j) - 'A')
            }
            //words中存在v 并且 doubleWords中不存在v
            if(!words.add(v) && doubleWords.add(v)) {
                rv.add( s.substring(i, i + 10) );
            }
        }
        return rv;
    }



}
