package OJ;

import java.util.*;

/**
 * Created by YYT on 2016/10/27.
 *Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 * 简单的说就是求数组的交，保证有序和不重复
 */
public class IntersectionTwoArrays {
    /**
     * 利用treeSet
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        TreeSet<Integer> resSet = new TreeSet<Integer>();
        int i = 0;
        while (i<nums1.length) {
            treeSet.add(nums1[i]);i++;
        }
        i = 0;
        while (i<nums2.length){
            if(treeSet.contains(nums2[i])){
                resSet.add(nums2[i]);
            }
            i++;
        }
        int[] resArr = new int[resSet.size()];
        i = 0;
        Iterator<Integer> ite = resSet.iterator();
        //TreeSet升序存储
        while (ite.hasNext()){
            resArr[i] = ite.next();
            i++;
        }
        return resArr;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {2, 1};
        IntersectionTwoArrays o = new IntersectionTwoArrays();
        long t1 = System.currentTimeMillis();
        int[] nums = o.intersection(nums1, nums2);
        long d1 = System.currentTimeMillis() - t1;
        t1 = System.currentTimeMillis();
        //d1 = System.currentTimeMillis() - t1;
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

    }




}
