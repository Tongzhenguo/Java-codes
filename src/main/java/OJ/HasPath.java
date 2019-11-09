package OJ;

/**
 * Created by tongzhenguo on 2019/11/6.
 */
public class HasPath {

    // 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
    // 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
    // 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
    // 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
    // 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(str.length == 0 || matrix.length == 0 || rows*cols < str.length){
            return false;
        }

// note(我去个地方啊)
//        0.根据给定数组，初始化一个标志位数组，初始化为false，表示未走过，true表示已经走过，不能走第二次
//        1.根据行数和列数，遍历数组，先找到一个与str字符串的第一个元素相匹配的矩阵元素，进入judge程序
//        2.根据i和j先确定一维数组的位置，因为给定的matrix是一个一维数组
//        3.确定递归终止条件：越界，当前找到的矩阵值不等于数组对应位置的值，已经走过的，这三类情况，都直接false，说明这条路不通
//        4.若ok，就是待判定的字符串str的索引已经判断到了最后一位，此时说明是匹配成功的
//        5.下面就是本题的精髓(回溯)，递归不断地寻找周围四个格子是否符合条件，只要有一个格子符合条件，
//          就继续再找这个符合条件的格子的四周是否存在符合条件的格子，直到k到达末尾或者不满足递归条件就停止。
//          走到这一步，说明本次是不成功的，我们要还原一下标志位数组index处的标志位，进入下一轮的判断。

        // 初始化一个标志位数组，初始化为false，表示未走过，true表示已经走过，不能走第二次
        boolean[] trvelPos = new boolean[rows*cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                // 遍历数组，找到一个与str字符串的第一个元素相匹配的矩阵元素，进入judge程序
                if(matrix[i*cols+j] == str[0]){
                    if(judge(matrix,rows,cols,str,trvelPos,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // k指示现在str数组匹配到的位置
    private boolean judge(char[] matrix, int rows, int cols, char[] str, boolean[] trvelPos,int i,int j,int k) {
        // 确定递归终止条件：越界，当前找到的矩阵值不等于数组对应位置的值，已经走过的，这三类情况，都直接false，说明这条路不通
        if(i>=rows || j>=cols || i<0 || j<0){
            return false;
        }
        if(matrix[i*cols+j] != str[k]){
            return false;
        }
        if(trvelPos[i * cols + j]){
            return false;
        }
        if(k==str.length-1){
            return true;
        }
        // 递归不断地寻找周围四个格子是否符合条件，只要有一个格子符合条件，
        // 就继续再找这个符合条件的格子的四周是否存在符合条件的格子，直到k到达末尾或者不满足递归条件就停止。
        trvelPos[i*cols+j] = true;
        if(judge(matrix,rows,cols,str,trvelPos,i-1,j,k+1)
                || judge(matrix,rows,cols,str,trvelPos,i+1,j,k+1)
                || judge(matrix,rows,cols,str,trvelPos,i,j-1,k+1)
                || judge(matrix,rows,cols,str,trvelPos,i,j+1,k+1)){
            return true;
        }
        // 走到这一步，说明i,j起点是不成功的，我们要还原一下标志位数组，进入下一轮的判断。
        trvelPos[i*cols+j] = false;
        return false;
    }

    public static void main(String[] args) {
        boolean[] trvelPos = new boolean[2];
        System.out.println(trvelPos[0]);

    }

}
