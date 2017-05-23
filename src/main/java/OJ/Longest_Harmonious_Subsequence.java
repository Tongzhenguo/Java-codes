package OJ;

import java.util.HashMap;

/**
 * Created by Tongzhenguo on 2017/5/23.
 *
 We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 一个数组的最大值和最小值相差1就称为harmonious array
 给定一个数组，根据数组中的元素构造一个harmonious array，返回harmonious array的最大长度
 Example 1:
 Input: [1,3,2,2,5,2,3,7]
 Output: 5
 Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 */
public class Longest_Harmonious_Subsequence {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> pairCount = new HashMap<Integer, Integer>();
        int maxCount = 0;
        int curMx = 0;
        for( Integer i:nums ){
            pairCount.put(i,pairCount.getOrDefault(i,0)+1  );
            //存在harmonious array
            if(  Math.max(pairCount.getOrDefault(i + 1, 0),pairCount.getOrDefault(i-1, 0) )!=0  ){
                curMx = pairCount.getOrDefault(i, 0) + Math.max(pairCount.getOrDefault(i + 1, 0),pairCount.getOrDefault(i-1, 0) );
            }
            if( curMx > maxCount ){
                maxCount = curMx;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(new Longest_Harmonious_Subsequence().findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}) );

    }
}
