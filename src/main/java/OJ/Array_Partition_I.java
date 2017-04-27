package OJ;

import java.util.Arrays;

/**
 * Created by arachis on 2017/4/24.
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
  一个2n长度的整型数组，设计算法将这些整数分成n对，比如 (a1, b1), (a2, b2), ..., (an, bn) ,使得sum( min(ai,bi) )尽可能大
 Example 1:
 Input: [1,4,3,2]
 Output: 4
 */
public class Array_Partition_I {
    public int arrayPairSum(int[] nums) {
     Arrays.sort(nums);
     int result = 0;
     //The algorithm is first sort the input array and then the sum of 1st, 3rd, 5th..., is the answer.
     for (int i = 0; i < nums.length; i += 2) {
      result += nums[i];
     }
     return result;
    }


 /**
  * 附：证明
  * Assume in each pair i, bi >= ai.
  Denote Sm = min(a1, b1) + min(a2, b2) + ... + min(an, bn). The biggest Sm is the answer of this problem. Given 1, Sm = a1 + a2 + ... + an.
  Denote Sa = a1 + b1 + a2 + b2 + ... + an + bn. Sa is constant for a given input.
  Denote di = |ai - bi|. Given 1, di = bi - ai. Denote Sd = d1 + d2 + ... + dn.
  So Sa = a1 + a1 + d1 + a2 + a2 + d2 + ... + an + an + di = 2Sm + Sd => Sm = (Sa - Sd) / 2. To get the max Sm, given Sa is constant, we need to make Sd as small as possible.
  So this problem becomes finding pairs in an array that makes sum of di (distance between ai and bi) as small as possible.
  Apparently, sum of these distances of adjacent elements is the smallest. If that's not intuitive enough, see attached picture. Case 1 has the smallest Sd.
  */
}