package OJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arachis on 2017/8/23.
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


 */
public class Restore_IP_Addresses {
    /**
     * 3-loop divides the string s into 4 substring: s1, s2, s3, s4. Check if each substring is valid.
     In isValid, strings whose length greater than 3 or equals to 0 is not valid;
     or if the string's length is longer than 1 and the first letter is '0' then it's invalid;
     or the string whose integer representation greater than 255 is invalid.
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
}
