package OJ;

/**
 * Created by arachis on 2016/11/18.
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 *You may assume that the array is non-empty and the majority element always exist in the array.
 * 简单的说就是给一个n个元素的数组，找到出现至少 n/2次的元素
 */
public class MajorityElement {
    /**
     * 最简单的就是使用一个map计数每个元素（时间复杂度o()）
     *  从网上get到一个空间复杂度低的方法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        //init
        int major = 0;
        int count = 0;//count(major) - count(other)
        for(int i:nums){
            if(0 == count){
                major = i;
                count += 1;
            }else if(i == major){
                count ++;
            }else{
                count --;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{1, 1, 1, 2, 3}));
    }


}
