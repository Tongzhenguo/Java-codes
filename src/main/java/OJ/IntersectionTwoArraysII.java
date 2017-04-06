package OJ;

import java.util.*;

/**
 * Created by arachis on 2016/12/27.
 *
 *Given two arrays, write a function to compute their intersection.
 *
 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 *
 * Follow up:
 *What if the given array is already sorted? How would you optimize your algorithm?
 *What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 */
public class IntersectionTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> nums1Counter = new HashMap();
        Map<Integer,Integer> nums2Counter = new HashMap();
        List<Integer> list = new ArrayList();

        for(int i :nums1){
            if(! nums1Counter.containsKey(i)){
                nums1Counter.put(i,0);
            }
            nums1Counter.put(i,nums1Counter.get(i)+1);
        }
        for(int i:nums2){
            if(! nums2Counter.containsKey(i)){
                nums2Counter.put(i,0);
            }
            nums2Counter.put(i,nums2Counter.get(i)+1);
        }

        for(int i :nums1Counter.keySet()){
            if(nums2Counter.containsKey(i)){
                for(int j=0;j<Math.min(nums1Counter.get(i),nums2Counter.get(i));j++){
                    list.add(i);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }
}
