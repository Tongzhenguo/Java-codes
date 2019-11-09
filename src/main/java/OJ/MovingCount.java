package OJ;

/**
 * Created by tongzhenguo on 2019/11/6.
 */
public class MovingCount {

    int movingCount = 0;
    // 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
    // 但是不能进入行坐标和列坐标的数位之和大于k的格子。
    // 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
    // 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
    public int movingCount(int threshold, int rows, int cols) {
        // 回溯解空间，m*n矩阵且满足约束条件(行坐标和列坐标的数位之和小于等于k)和边界条件(行i<m,列j<n)的一个格子
        // 搜索策略：上下左右

        if(rows == 0 || cols == 0 || threshold<0){
            return 0;
        }
        // 用来标记游走过
        boolean[][] travelPos = new boolean[rows][cols];
        // 开始递归的移动
        move_recursion(threshold,rows,cols,travelPos, 0,0);
        return movingCount;
    }

    private void move_recursion(int threshold, int rows, int cols, boolean[][] travelPos, int i, int j) {
        // 不满足边界条件
        if(i<0 || j<0 || i>=rows || j>=cols){
            return ;
        }
        // 已经访问过了
        if(travelPos[i][j]){
            return ;
        }
        // 判定满足约束条件(行坐标和列坐标的数位之和小于等于k)
        int sum = 0;
        // 变量row，col保存i,j
        int row = i,col = j;
        while (row>0 || col>0){
            if(row>0){
              sum += row % 10;
              row /= 10;
            }
            if(col>0){
                sum += col % 10;
                col /= 10;
            }
            if(sum > threshold){
              // 这里不满足约束条件，需要回溯
              travelPos[i][j] = false;
              return ;
            }
        }
        // 满足约束条件，开始下一轮dfs
        travelPos[i][j] = true;
        this.movingCount++;
        System.out.println(""+i+","+j);
        move_recursion(threshold,rows,cols,travelPos, i+1,j);
        move_recursion(threshold,rows,cols,travelPos, i-1,j);
        move_recursion(threshold,rows,cols,travelPos, i,j-1);
        move_recursion(threshold,rows,cols,travelPos, i,j+1);
    }


    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(1,10,10));

    }

}
