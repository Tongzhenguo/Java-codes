package OJ;

import java.util.List;

/**
 * Created by Tongzhenguo on 2017/7/4.
 * Given m arrays, and each array is sorted in ascending order.
 * Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance.
 * We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

 Example 1:
 Input:
 [[1,2,3],
 [4,5],
 [1,2,3]]
 Output: 4
 Explanation:
 One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 Note:
 Each given array will have at least 1 number. There will be at least two non-empty arrays.
 The total number of the integers in all the m arrays will be in the range of [2, 10000].
 The integers in the m arrays will be in the range of [-10000, 10000].
 *
 */
public class Maximum_Distance_in_Arrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);

        for (int i = 1; i < arrays.size(); i++) {
            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));//4-3
            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));//5-1
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));//5
            min = Math.min(min, arrays.get(i).get(0));//1
        }

        return result;
    }

}
