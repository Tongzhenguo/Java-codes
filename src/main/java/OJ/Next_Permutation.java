package OJ;

/**
 * Created by arachis on 2017/4/17.
 * Implement next permutation, which rearranges numsbers into the lexicographically next greater permutation of numsbers.
 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 permutation:排列
 题意寻找比当前排列顺序大的下一个排列。
 因为降序序列是没法变的更大的，所以从后往前找到第一个升序对的位置。
 然后就存在调整大小排列顺序的可能，从后往前找到比当前位置大的元素，交换之。

 The replacement must be in-place, do not allocate extra memory.
 原地实现，不能申请额外内存

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */

/**
 * 当前位置后面的元素还是降序排列，将他们反转得到最小顺序排列。其实就是原来当前位置元素后面是最大的排列，而交换后的新元素之后是最小的排列，他们就是相邻的顺序。
 当不存在升序，则当前排列是最大排列，只要旋转整个序列变成最小排列。

 Start from its last element, traverse backward to find the first one with index i that satisfy nums[i-1] < nums[i]. So, elements from nums[i] to nums[n-1] is reversely sorted.
 To find the next permutation, we have to swap some numbers at different positions, to minimize the increased amount, we have to make the highest changed position as high as possible.
 Notice that index larger than or equal to i is not possible as nums[i,n-1] is reversely sorted.
 So, we want to increase the numsber at index i-1, clearly, swap it with the smallest numsber between nums[i,n-1] that is larger than nums[i-1].

 For example, original numsber is 121543321, we want to swap the '1' at position 2 with '2' at position 7.
 The last step is to make the remaining higher position part as small as possible, we just have to reversely sort the nums[i,n-1]
 */
public class Next_Permutation {
    public void nextPermutation(int[] nums) {

        int n=nums.length;
        if(n<2)
            return;
        // Start from its last element, traverse backward to find the first one with index i that satisfy nums[i-1] < nums[i].
        int index=n-1;
        while(index>0){
            if(nums[index-1]<nums[index])
                break;
            index--;
        }
        // So, elements from nums[i] to nums[n-1] is reversely sorted.
        if(index==0){
            reverseSort(nums,0,n-1);
            return;
        }
        else{
            // to minimize the increased amount, we have to make the highest changed position as high as possible.
            //找到一个大于nums[index-1]的尽可能靠后的位置，然后交换之
            int val=nums[index-1];
            int j=n-1;
            while(j>=index){
                if(nums[j]>val)
                    break;
                j--;
            }
            swap(nums,j,index-1);
            reverseSort(nums,index,n-1);
            return;
        }

    }

    public void swap(int[] nums, int i, int j){
        int temp=0;
        temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public void reverseSort(int[] nums, int start, int end){
        if(start>end)
            return;
        for(int i=start;i<=(end+start)/2;i++)
            swap(nums,i,start+end-i);
    }

}
