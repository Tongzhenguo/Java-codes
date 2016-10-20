package OJ;

/**
 * Created by YYT on 2016/10/20.
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 *For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 *Note:
 *You must do this in-place without making a copy of the array.
 *Minimize the total number of operations.
 *
 * 简单的说就是将所有的0移到数组的末尾，要求自能操作本数组，最小化操作次数
 */
public class MoveZeroes {
    /**
     * 我的想法是两个指针，一个找到非零的位置，一个是要替换的位置
     * 停止条件是移动到数组末尾，然后将替换位置之后的都换为0
     * 时间复杂度是O(N)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while(nums[i] != 0 && i<nums.length-1){//找到第一个0，注意越界
            i++;
        }
        j = i;
        while (j<nums.length){//注意越界
            if(nums[j] != 0) {//找到零，然后替换0
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        while (i<nums.length && j>=nums.length){//注意越界,当j遍历完，i之后的应该都是0
            nums[i] = 0;
            i = i+1;
        }
    }

    public static void main(String[] args) {
        MoveZeroes o = new MoveZeroes();
        int[] nums = {1};
        int[] nums1 = {1,0,1,0,13};
        o.moveZeroes(nums1);
        for(int i=0;i< nums1.length;i++){
            System.out.println(nums1[i]);
        }
    }
}
