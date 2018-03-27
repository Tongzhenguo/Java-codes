package OJ;

import java.util.ArrayList;

/**
 * Created by arachis on 2018/3/28.
 *
 * 有一个二维数组(n*n)，写程序实现从右上角到左下角沿主对角线方向打印。
 *
 * 测试样例：
 给定一个二位数组arr及题目中的参数n，请返回结果数组。
 [[1，2，3，4]，[5，6，7，8]，[9，10，11，12]，[13，14，15，16]]，4

 返回1：
 4
 3 8
 2 7 12
 1 6 11 16
 5 10 15
 9 14
 13

 返回2：
 [4，3，8，2，7，12，1，6，11，16，5，10，15，9，14，13]
 *
 */
public class PrintSquarematrixMainByDiagonalLine {

    public static void main(String[] args) {


        int[][] a = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
//      int[][] a = {{1,2,3},
//              {4,5,6},
//              {7,8,9}};
        int size = a.length;
        int len = 2*a.length-1;//一共生成几行结果
        ArrayList<Integer> one_line_num = new ArrayList<Integer>();
        for(int k=0;k<len;k++){
            //规律是第 K的 列号-行号=size-1-k
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    if(j-i == size-1-k){
                        System.out.print(a[i][j]+" ");
                        one_line_num.add(a[i][j]);
                    }
                }
            }
            System.out.println("");
        }

        System.out.println(one_line_num);
    }

}
