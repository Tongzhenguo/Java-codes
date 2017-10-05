package OJ;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by arachis on 2017/10/5.
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:
 Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 Return: [1,2],[1,4],[1,6]
 All possible pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

 Example 2:
 Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 Return: [1,1],[1,1]
 All possible pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

 Example 3:
 Given nums1 = [1,2], nums2 = [3],  k = 3
 Return: [1,3],[2,3]
 All possible pairs are returned from the sequence:
 [1,3],[2,3]
 */
public class Find_K_Pairs_with_Smallest_Sums {
    /**
     * Use min_heap to keep track on next minimum pair sum, and we only need to maintain K possible candidates in the data structure.
     *  For every numbers in nums1, its best partner(yields min sum) always strats from nums2[0] since arrays are all sorted
     *  And for a specific number in nums1, its next candidate sould be [this specific number] + nums2[current_associated_index + 1], unless out of boundary
     *  The run time complexity is O(kLogk) since que.size <= k and we do at most k loop.
     */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }

}
