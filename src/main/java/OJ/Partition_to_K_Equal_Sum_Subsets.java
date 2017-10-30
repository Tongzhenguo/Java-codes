package OJ;

/**
 * Created by arachis on 2017/10/24.
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * <p/>
 * Example 1:
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Note:
 * <p/>
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */
public class Partition_to_K_Equal_Sum_Subsets {

    /**
     * Assume sum is the sum of nums[] .
     * The dfs process is to find a subset of nums[] which sum equals to sum/k.
     * We use an array visited[] to record which element in nums[] is used.
     * Each time when we get a cur_sum = sum/k, we will start from position 0 in nums[] to look up the elements that are not used yet and find another cur_sum = sum/k.
     * <p/>
     * An corner case is when sum = 0, my method is to use cur_num to record the number of elements in the current subset.
     * Only if cur_sum = sum/k && cur_num >0, we can start another look up process.
     * <p/>
     * Some test cases may need to be added in:
     * nums = {-1,1,0,0}, k = 4
     * nums = {-1,1}, k = 1
     * nums = {-1,1}, k = 2
     * nums = {-1,1,0}, k = 2
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (k <= 0 || sum % k != 0) return false;
        int[] visited = new int[nums.length];
        return canPartition(nums, visited, 0, k, 0, 0, sum / k);
    }

    public boolean canPartition(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target) {
        if (k == 1) return true;
        if (cur_sum == target && cur_num > 0) return canPartition(nums, visited, 0, k - 1, 0, 0, target);
        for (int i = start_index; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (canPartition(nums, visited, i + 1, k, cur_sum + nums[i], cur_num++, target))
                    return true;
                visited[i] = 0;
            }
        }
        return false;
    }

}
