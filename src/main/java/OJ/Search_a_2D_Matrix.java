package OJ;

/**
 * Created by arachis on 2017/4/10.
 * 设计算法，在一个二维矩阵中搜索一个数
   其中矩阵有如下特征：1.每行从左到右递增；每行的第一个数都比上一行最大的数大（杨氏矩阵）

 */
public class   Search_a_2D_Matrix {
    /**
     *  Do binary search in this "ordered" matrix
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0) return false;
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num];

            if( mid_value == target){
                return true;

            }else if(mid_value < target){
                //Should move a bit further, otherwise dead loop.
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }

    

}
