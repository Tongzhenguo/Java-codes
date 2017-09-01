package OJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arachis on 2017/9/1.
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class Palindrome_Partitioning {
    //Backtracking solution.
    /**
     * if the input is "aab", check if [0,0] "a" is palindrome. then check [0,1] "aa", then [0,2] "aab".
     While checking [0,0], the rest of string is "ab", use ab as input to make a recursive call.

     in this example, in the loop of i=l+1, a recursive call will be made with input = "ab".
     Every time a recursive call is made, the position of l move right.

     How to define a correct answer?
     Think about DFS, if the current string to be checked (Palindrome) contains the last position, in this case "c",
     this path is a correct answer, otherwise, it's a false answer.
     */
    List<List<String>> resultLst;
    ArrayList<String> currLst;
    public List<List<String>> partition(String s) {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        backTrack(s,0);
        return resultLst;
    }
    public void backTrack(String s, int l){
        if(currLst.size()>0 //the initial str could be palindrome
                && l>=s.length()){
            List<String> r = (ArrayList<String>) currLst.clone();
            resultLst.add(r);
        }
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                if(l==i)
                    currLst.add(Character.toString(s.charAt(i)));
                else
                    currLst.add(s.substring(l,i+1));
                backTrack(s,i+1);//Removes the element at the specified position in this list.
                currLst.remove(currLst.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }

}
