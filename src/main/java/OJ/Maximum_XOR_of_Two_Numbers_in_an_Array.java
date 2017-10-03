package OJ;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by arachis on 2017/10/3.
 *
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

 Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

 Could you do this in O(n) runtime?

 Example:

 Input: [3, 10, 5, 25, 2, 8]

 Output: 28

 Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class Maximum_XOR_of_Two_Numbers_in_an_Array {
    /**
     * narrow:（使）变窄
     * to iteratively determine what would be each bit of the final result from left to right.
     *  And it narrows down the candidate group iteration by iteration.
     *  e.g. assume input are a,b,c,d,...z, 26 integers in total.
     *   In first iteration, if you found that a, d, e, h, u differs on the MSB(most significant bit), so you are sure your final result's MSB is set.
     *   Now in second iteration, you try to see if among a, d, e, h, u there are at least two numbers make the 2nd MSB differs, if yes, then definitely, the 2nd MSB will be set in the final result.
     *   And maybe at this point the candidate group shinks from a,d,e,h,u to a, e, h.
     *   Implicitly, every iteration, you are narrowing down the candidate group, but you don't need to track how the group is shrinking, you only cares about the final result.
     */
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }


}
