package OJ;

/**
 * Created by arachis on 2017/8/18.
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 *
 */
public class H_Index_II {
    /**
     * The basic idea of this solution is to use binary search to find the minimum index such that

     citations[index] >= length(citations) - index
     After finding this index, the answer is length(citations) - index.

     This logic is very similar to the C++ function lower_bound or upper_bound.
     */
    public int hIndex(int[] citations) {
        int len = citations.length;

        int first = 0;
        int mid;
        int count = len;
        int step;

        while (count > 0) {
            step = count / 2;
            mid = first + step;
            if (citations[mid] < len - mid) {
                first = mid + 1;
                count -= (step + 1);
            }
            else {
                count = step;
            }
        }

        return len - first;
    }

}


