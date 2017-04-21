package OJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arachis on 2017/4/21.
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 给定整型数组，设计算法找到三个数，使得相加的和为0;
 Note: The solution set must not contain duplicate triplets.
注：结果不能重复
 For example, given array S = [-1, 0, 1, 2, -1, -4],
 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 *
 */
public class ThreeSum {
    /**
     * The idea is to sort an input array and then run through all indices of a possible first element of a triplet.
     * For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array.
     * Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
     */
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int i = 0; i < num.length-2; i+=1) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) { //避免重复
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo+=1;//避免重复
                        while (lo < hi && num[hi] == num[hi-1]) hi-=1;//避免重复
                        lo+=1; hi-=1;
                    }
                    else if (num[lo] + num[hi] < sum) lo+=1;
                    else hi-=1;
                }
            }
        }
        return res;
    }


}
