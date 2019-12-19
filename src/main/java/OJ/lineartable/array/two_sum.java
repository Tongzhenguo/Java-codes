package OJ.lineartable.array;

import LCTools.FastRun;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tongzhenguo on 2019/12/19.
 */
public class two_sum {

    // 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
    //你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);
        for (int i = 0; i <nums.length; i++) {
            // 你不能重复利用这个数组中同样的元素。
            if(map.containsKey(target-nums[i])
                    // && map.get(target-nums[i]) != i 这个判断没有必要
                    // 因为先查表后加新kv对，所以两个下标必然不相同
            ){
                array[0] = i;
                array[1] = map.get(target-nums[i]);
                break;
            }
            // 存到Map：k:num v:pos;待查表
            map.put(nums[i],i);
        }
        return array;
    }

    public static void main(String[] args) {

        int[] x = new two_sum().twoSum(new int[]{3, 3}, 6);
        System.out.println(x[0]);
        System.out.println(x[1]);
    }

}
