package OJ.lineartable.array;

import java.util.Arrays;

/**
 * Created by tongzhenguo on 2019/12/19.
 */
public class remove_duplicates_from_sorted_array {

    // 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    public int removeDuplicates(int[] nums) {

        // todo 官方题解
        // 数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，而 j 是快指针。只要 nums[i] = nums[j]，我们就增加 j 以跳过重复项。
        // 当我们遇到 nums[j] ！= nums[i]跳过重复项的运行已经结束，因此我们必须把nums[j]的值复制到 nums[i + 1]。
        // 然后递增i，接着我们将再次重复相同的过程，直到j到达数组的末尾为止。

        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {

//        int[] input = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] input = new int[]{1,1};
        int output = new remove_duplicates_from_sorted_array().removeDuplicates(input);
        System.out.println(output);
        System.out.println(Arrays.toString(input));
    }

}
