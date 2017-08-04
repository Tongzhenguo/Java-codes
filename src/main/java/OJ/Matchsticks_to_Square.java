package OJ;

import java.util.Arrays;

/**
 * Created by arachis on 2017/8/3.
 * 火柴杆:matchsticks
 *
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has,
 * please find out a way you can make one square by using up all those matchsticks.
 * You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

 Your input will be several matchsticks the girl has, represented with their stick length.
 Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.

 Example 1:
 Input: [1,1,2,2,2]
 Output: true
 Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.

 Example 2:
 Input: [3,3,3,3,4]
 Output: false
 Explanation: You cannot find a way to form a square with all the matchsticks.
 */
public class Matchsticks_to_Square {
    /*
    * According to https://en.wikipedia.org/wiki/Partition_problem,
    * the partition problem (or number partitioning) is the task of deciding whether a given multiset S of positive integers can be partitioned into two subsets S1 and S2
    * such that the sum of the numbers in S1 equals the sum of the numbers in S2. The partition problem is NP-complete.

     Sorting the input array DESC will make the DFS process run much faster.
     Reason behind this is we always try to put the next matchstick in the first subset.
     If there is no solution, trying a longer matchstick first will get to negative conclusion earlier
    * */
    public boolean makesquare(int[] nums) {
     if (nums == null || nums.length < 4) return false;
     int sum = 0;
     for (int num : nums) sum += num;
     if (sum % 4 != 0) return false;

     Arrays.sort(nums);
     reverse(nums);

     return dfs(nums, new int[4], 0, sum / 4);
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }

    private boolean dfs(int[] nums, int[] sums, int index, int target) {
          if (index == nums.length) {
           if (sums[0] == target && sums[1] == target && sums[2] == target) {
            return true;
           }
           return false;
          }

          for (int i = 0; i < 4; i++) {
           if (sums[i] + nums[index] > target)
               continue;
           sums[i] += nums[index];
           if (dfs(nums, sums, index + 1, target))
               return true;
           sums[i] -= nums[index];
          }
          return false;
    }

}
