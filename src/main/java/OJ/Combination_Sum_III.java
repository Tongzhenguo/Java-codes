package OJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arachis on 2017/4/23.
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 设计算法找到k个数的所有不重复的组合，每个数是1到9的整数，使得加和等于n

 */
public class Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
        //递归出口
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            //递归加法
            combination(ans, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }

}
