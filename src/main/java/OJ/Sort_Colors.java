package OJ;

/**
 * Created by arachis on 2017/4/21.
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 一个n物体组成的数组，他们可能是红色，白色或者蓝色（0，1，2）；设计算法进行排序，使得相同的颜色相邻，并且红白蓝的顺序
 Note:
 You are not suppose to use the library's sort function for this problem.
 注：不能使用现有的库函数
 *
 */
public class Sort_Colors {
    public void sortColors(int[] nums) {
        int second = nums.length - 1;
        int zero=0;
        for (int i=0; i<=second; i++) {
            while (nums[i]==2 && i<second){//2移到最后
                int tmp = nums[i];
                nums[i] = nums[second];
                nums[second] = tmp;
                second -= 1;
            }
            while (nums[i]==0 && i>zero){//0移到最前
                int tmp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = tmp;
                zero += 1;
            }
        }
    }

}
