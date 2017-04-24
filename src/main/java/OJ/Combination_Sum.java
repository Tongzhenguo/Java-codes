package OJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arachis on 2017/4/24.
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 对于一个不包含重复的候选集C，设计算法找到所有的组合，可以多次选择同一元素，使得其和为T
 The same repeated number may be chosen from C unlimited number of times.
注：元素都是正整数

 */
public class Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        //后向算法
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;

    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;//确定这个组合不满足，不再搜索
        else if(remain == 0) list.add(new ArrayList<Integer>(tempList));//找到一个想要的组合
        else{ //不确定组合是否满足，先加上去再说
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);//保存遍历到的每一个元素
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);//每一次回溯一小步，再去寻找新的可能
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        new Combination_Sum().combinationSum( nums,7 );

    }


}
