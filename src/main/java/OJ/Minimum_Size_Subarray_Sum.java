package OJ;

/**
 * Created by arachis on 2017/4/23.
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 长度为n的正整数数组和一个正整数s,找到大于s的最小的子数组，如果不存在返回0
 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 */
public class Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0, j = 0;//i指向子数组开始的位置，j保存子数组结束的位置
        int sum = 0, min = nums.length+1;

        while (j < nums.length) {
            sum += nums[j];
            j += 1;
            //先一直加，加到比目标大
            while (sum >= s) {
                //计算最小的长度，并更新
                min = Math.min(min, j - i);
                sum -= nums[i];
                i += 1;
            }
        }

        return min == nums.length+1 ? 0 : min;
    }

}
