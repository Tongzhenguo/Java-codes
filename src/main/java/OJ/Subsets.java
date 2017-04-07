package OJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    /**
     * Created by arachis on 2017/4/7.
     * 给定去重的集合，设计算法找到所有可能的子集集合
     * 例如：
     * If nums = [1,2,3], a solution is:
     [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]] 注意输出顺序
     需要保存当前已经遍历过的元素
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<Integer>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int []nums = {1,2,3};
        System.out.println(new Subsets().subsets(nums) );
    }

}
