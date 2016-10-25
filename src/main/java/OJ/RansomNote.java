package OJ;

/**
 * Created by Administrator on 2016/10/25.
 *  Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,
 *   write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;
 *  otherwise,  it  will  return  false.   
 *
 * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

 Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
 *
 *大概的意思是判断通过杂志中的字符串（magazines）能否构成一个绑架告示（ransom）
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = ransomNote.toCharArray();
        int i = 0;
        while (magazine.length()>0 && i<chars.length){
            if(magazine.contains(""+chars[i])){
                magazine = magazine.replaceFirst("" + chars[i], "");
                i++;
            }else {
                return false;
            }
        }
        return i == chars.length;
    }

    public static void main(String[] args) {
        RansomNote o = new RansomNote();
        System.out.println(o.canConstruct("a", "b"));
        System.out.println(o.canConstruct("aa", "ab"));
        System.out.println(o.canConstruct("aa", "aab"));
    }
}
