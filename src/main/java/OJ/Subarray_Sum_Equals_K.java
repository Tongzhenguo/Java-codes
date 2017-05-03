package OJ;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arachis on 2017/5/3.
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 设计算法，找到连续子数组，使得和为给定值k;求这些满足条件的子数组的个数
 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2
 */
public class Subarray_Sum_Equals_K {
    /**
     * we know the key to solve this problem is SUM[i, j].
     * So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j].
     * To achieve this, we just need to go through the array, calculate the current sum and save number of all seen PreSum to a HashMap.
     * Time complexity O(n), Space complexity O(n).
     */
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        //calculate the current sum and save number of all seen PreSum to a HashMap.
        Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }

            if( ! preSum.containsKey(sum) ){
                preSum.put(sum,0);
            }
            preSum.put(sum, preSum.get(sum) + 1);
        }

        return result;
    }

}
