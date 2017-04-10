package OJ;

/**
 * Created by arachis on 2017/4/10.
 * 一个有序数组，要求最多重复出现两次，超出的要删除
 *  we need a count variable to keep how many times the duplicated element appears, if we encounter a different element, just set counter to 1,
 *  if we encounter a duplicated one, we need to check this count, if it is already k, then we need to skip it, otherwise, we can keep this element.
 */
public class Remove_Duplicates_from_Sorted_Array_II {
    int removeDuplicates(int A[], int n, int k) {

        if (n <= k) return n;

        int i = 1, j = 1;
        int cnt = 1;
        while (j < n) {
            if (A[j] != A[j-1]) {
                cnt = 1;
                A[i] = A[j];
                i += 1;
            }
            else {
                if (cnt < k) {
                    A[i] = A[j];
                    i += 1;
                    cnt += 1;
                }
            }

            j += 1;
        }
        return i;
    }

    public int removeDuplicates(int[] nums) {
        return removeDuplicates(nums,nums.length,2);
    }

}
