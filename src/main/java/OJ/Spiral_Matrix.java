package OJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arachis on 2017/4/11.
 * 给定一个矩阵，返回顺时针顺序重新构成的数组
 * 上右下左四个边分别变化，每遍历完一个边都要判断下是否已经遍历过
 */
public class Spiral_Matrix {
    //上右下左四个边分别变化，每遍历完一个边都要判断下是否已经遍历过
    public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<Integer>();
            if(matrix.length == 0 || matrix[0].length == 0) return res;

            int top = 0;
            int bottom = matrix.length-1;
            int left = 0;
            int right = matrix[0].length-1;

            while(true){
                for(int i = left; i <= right; i++) res.add(matrix[top][i]);
                top+=1;
                if(left > right || top > bottom) break;

                for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
                right-=1;
                if(left > right || top > bottom) break;

                for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
                bottom-=1;
                if(left > right || top > bottom) break;

                for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
                left+=1;
                if(left > right || top > bottom) break;
            }
            return res;
        }

}
