package OJ;

/**
 * Created by Administrator on 2016/10/11.
 * Write a function that takes a string as input and returns the string reversed.
 */
public class ReverseString {
    /**
     * 我的思路：
     *      可以通过左右两个指针指示
     *      来交换两个字母的位置；
     *      最终的停止条件是当左指针等于右指针（奇数)
     *      或者左指针大于右指针。
     * @param s
     * @return
     */
    public String reverseString(String s) {
        byte[] bytes = s.getBytes();
        int left=0;
        int right = s.length()-1;
        while(left <right){
            Byte tmp = bytes[left];
            bytes[left] = bytes[right];
            bytes[right] = tmp;
            left++;
            right--;
        }
        return new String(bytes);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString("ABC"));
        System.out.println(new ReverseString().reverseString("ABCD"));
        System.out.println(new ReverseString().reverseString("A"));
    }


}
