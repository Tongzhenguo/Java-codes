package OJ;

/**
 * Created by arachis on 2017/2/4.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {

        int xor = 0, i = 0;
        for (; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int i = missingNumber.missingNumber(new int[]{0});
        System.out.println(i);

    }

}
