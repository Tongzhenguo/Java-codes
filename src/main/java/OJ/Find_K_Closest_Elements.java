package OJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arachis on 2017/8/18.
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order.
 * If there is a tie, the smaller elements are always preferred.

 Example 1:
 Input: [1,2,3,4,5], k=4, x=3
 Output: [1,2,3,4]
 Example 2:
 Input: [1,2,3,4,5], k=4, x=-1
 Output: [1,2,3,4]
 */
public class Find_K_Closest_Elements {

    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> less = new ArrayList<>(), greater = new ArrayList<>(),
                lessResult = new LinkedList<>(), greaterResult = new LinkedList<>();

        for (Integer i : arr) {
            if (i <= x) less.add(i);
            else greater.add(i);
        }

        Collections.reverse(less);
        int  i = 0, j = 0, n = less.size(), m = greater.size();
        for (int size=0;size<k;size++) {
            if (i < n && j < m) {
                if (Math.abs(less.get(i) - x) <= Math.abs(greater.get(j) - x)) lessResult.add(less.get(i++));
                else greaterResult.add(greater.get(j++));
            }
            else if (i < n) lessResult.add(less.get(i++));
            else greaterResult.add(greater.get(j++));
        }

        Collections.reverse(lessResult);
        lessResult.addAll(greaterResult);
        return lessResult;
    }
}
