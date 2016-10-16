package OJ;

/**
 * Created by Administrator on 2016/10/16.
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

* For example,
* *"A man, a plan, a canal: Panama" is a palindrome.
* "race a car" is not a palindrome.

* Note:
* Have you consider that the string might be empty? This is a good question to ask during an interview.

* For the purpose of this problem, we define empty string as valid palindrome.
 * 简单的说就是给一个字符串，判断是否是回文（正反顺序一样），只考虑字母和数字
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        byte[] bytes = s.toLowerCase().getBytes();
        int left = 0;
        int right = bytes.length-1;
        while(left < right){
            if((bytes[left]>='0' && bytes[left]<='9') || (bytes[left]>='a' && bytes[left]<='z') ){
                if((bytes[right]>='0' && bytes[right]<='9') || (bytes[right]>='a' && bytes[right]<='z')){
                    if(bytes[left] != bytes[right]){
                        return false;
                    }else { //两头都是字母数字移动
                        left++;
                        right--;
                    }
                }else{
                    right--;//单向移动
                }
            }else{
                left++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome valid = new ValidPalindrome();
        System.out.println(valid.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
