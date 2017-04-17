package OJ;

/**
 * Created by arachis on 2017/4/14.
 * 假定一个升序的整型数组，在经过某种移动后，设计算法找到数组中的元素，如果不存在返回-1.假定数组不重复
 */
public class Search_in_Rotated_Sorted_Array {
    //
    public int search(int[] A, int target) {
        if( A == null || A.length==0) return -1;
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) return mid;
            //mid左边是有序的
            if (A[low] <= A[mid]) {
                if (target >= A[low] && target < A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {//mid右边是有序的 mid=4  4 5 6 7 0 1 2
                if (target > A[mid] && target <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return A[low] == target ? low : -1;
    }

}
