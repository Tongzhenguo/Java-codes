package OJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arachis on 2017/4/12.
 * 给定整型数组，每个元素的值都介于1和数组长度之间，有的出现两次，有的一次；
 * 设计算法找到重复元素，要求时间0(N),不是有额外内存
 */
public class Find_All_Duplicates_in_an_Array {

    // 因为nums[i]>0,故区分函数取-nums[i]<0,满足不等式的一定重复,要注意数组从0开始的问题
    // 如果nums[i]包含0,区分函数取nums[i]+n>=n

    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }

}
