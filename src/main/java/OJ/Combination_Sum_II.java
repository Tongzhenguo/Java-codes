package OJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arachis on 2017/4/24.
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 Each number in C may only be used once in the combination.
 对于一个不包含重复的候选集C，设计算法找到所有的组合，可以多次选择同一元素，使得其和为T；注意每一个元素只能被使用一次；只考虑正整数
 */
public class Combination_Sum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;

    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<Integer>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
