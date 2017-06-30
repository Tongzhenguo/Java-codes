package OJ;

import java.util.Arrays;

/**
 * Created by Tongzhenguo on 2017/6/30.
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.

 Example 1:
 Input: [1,2,3]
 Output: 6
 Example 2:
 Input: [1,2,3,4]
 Output: 24
 Note:
 The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 *
 */
public class Maximum_Product_of_Three_Numbers {
    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        //One of the Three Numbers is the maximum value in the array.
        int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];//正数三个以上
        int b = nums[0] * nums[1] * nums[nums.length - 1]; //有负数的情况
        return a > b ? a : b;
    }


}
