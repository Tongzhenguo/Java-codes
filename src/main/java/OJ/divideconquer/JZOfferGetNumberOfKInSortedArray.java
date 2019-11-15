package OJ.divideconquer;

/**
 * Created by tongzhenguo on 2019/10/9.
 */
public class JZOfferGetNumberOfKInSortedArray {
    // 统计一个数字在排序数组中出现的次数。
    public int GetNumberOfK(int [] array , int k) {
        // 非递归二分查找，代码清晰

        //因为data中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5
        //这两个数应该插入的位置，然后相减即可。
        return biSearch(array, k+0.5) - biSearch(array, k-0.5) ;
    }

    private int biSearch(int[] array, double v) {
        int left = 0;
        int right = array.length-1;
        while (left<=right){
            // 因为是整数数组，所以肯定存在浮点数关键字
            if(array[(left+right)/2]>v){
                right = (left+right)/2-1;
            }else{
                left = (left+right)/2+1;
            }
        }
        return left;
    }


//    public int GetNumberOfK(int [] array , int k) {
//        // 如果每次把问题做二分，分治算法复杂度应该是O(logn)
//        if(array.length == 0 || array[array.length-1]<k || array[0]>k){
//            return 0;
//        }
//        return helper(array,0,array.length-1,k);
//    }
//
//    int helper(int[] array, int left, int right, int k) {
//        if(left>right || array[left]>k || array[right]<k){
//            return 0;
//        }
//        int mid = (left+right)/2;
//        if(array[mid]>k){
//            // 1.中位数大于关键字，往左半边搜索
//            return helper(array,left,mid-1,k);
//        }else if(array[mid]<k){
//            // 2.中位数小于关键字，往右半边搜索
//            return helper(array,mid+1,right,k);
//        }else{
//            // 3.中位数等于关键字，左右两边都可能还存在关键字
//            int lefti = left;
//            int righti = right;
//            while (lefti<=righti && (array[lefti]<k || array[righti]>k)){
//                if(array[lefti]<k){
//                    lefti ++;
//                }
//                if(array[righti]>k){
//                    righti --;
//                }
//            }
//            return righti-lefti>=0?righti-lefti+1:0;
//        }
//    }


//    public int GetNumberOfK(int [] array , int k) {
//        // 基本上是O(n)时间的
//        if(array.length == 0 || array[array.length-1]<k || array[0]>k){
//            return 0;
//        }
//        // 对撞指针先扫一波？默认先升序
//        int left = 0;
//        int right = array.length-1;
//        while (left<=right && (array[left]<k || array[right]>k)){
//            if(array[left]<k){
//                left ++;
//            }
//            if(array[right]>k){
//                right --;
//            }
//        }
//        return right-left>=0?right-left+1:0;
//    }

    public static void main(String[] args) {

        int[] array = {1,2,3,3,3,3,5};
        System.out.println(new JZOfferGetNumberOfKInSortedArray().GetNumberOfK(array,2));
        System.out.println(new JZOfferGetNumberOfKInSortedArray().GetNumberOfK(array,3));
        System.out.println(new JZOfferGetNumberOfKInSortedArray().GetNumberOfK(array,4));

//        int[] array = {3};
//        System.out.println(new JZOfferGetNumberOfKInSortedArray().GetNumberOfK(array,3));
    }

}
