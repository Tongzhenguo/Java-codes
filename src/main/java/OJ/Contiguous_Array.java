package OJ;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tongzhenguo on 2017/5/11.
 *
 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 求最大连续子数组长度，其中数组元素只有0,1

 Example 1:
 Input: [0,1]
 Output: 2
 Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 Example 2:
 Input: [0,1,0]
 Output: 2
 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class Contiguous_Array {
 /**
  * The idea is to change 0 in the original array to -1.
  * Thus, if we find SUM[i, j] == 0 then we know there are even number of -1 and 1 between index i and j.
  * Also put the sum to index mapping to a HashMap to make search faster.
  */
 public int findMaxLength(int[] nums) {
  for (int i = 0; i < nums.length; i++) {
   if (nums[i] == 0) nums[i] = -1;
  }

  Map<Integer, Integer> sumToIndex = new HashMap<>();
  sumToIndex.put(0, -1);
  int sum = 0, max = 0;

  for (int i = 0; i < nums.length; i++) {
   sum += nums[i];// Also put the sum to index mapping to a HashMap to make search faster.
   if (sumToIndex.containsKey(sum)) {
    max = Math.max(max, i - sumToIndex.get(sum));
   }
   else {
    sumToIndex.put(sum, i);
   }
  }

  return max;
 }


}
