package OJ;

/**
 * Created by arachis on 2017/4/6.
 * 康威生命游戏
 每个细胞有两种状态-存活或死亡，每个细胞与以自身为中心的周围八格细胞产生互动。
 当前细胞为存活状态时，当周围低于2个（不包含2个）存活细胞时， 该细胞变成死亡状态。（模拟生命数量稀少）
 当前细胞为存活状态时，当周围有2个或3个存活细胞时， 该细胞保持原样。
 当前细胞为存活状态时，当周围有3个以上的存活细胞时，该细胞变成死亡状态。（模拟生命数量过多）
 当前细胞为死亡状态时，当周围有3个存活细胞时，该细胞变成存活状态。 （模拟繁殖）

 设计算法计算给定了当前状态下的下一个状态

 To solve it in place, we use 2 bits to store 2 states:
 [2nd bit, 1st bit] = [next state, current state]
 - 00  dead (next) <- dead (current)
 - 01  dead (next) <- live (current)
 - 10  live (next) <- dead (current)
 - 11  live (next) <- live (current)
 In the beginning, every cell is either 00 or 01.
 Notice that 1st state is independent of 2nd state.
 Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
 Let's count # of neighbors from 1st state and set 2nd state bit.
 统计当前状态（第二位）的邻居，然后设置第二个状态（第一位）
 Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
 In the end, delete every cell's 1st state by doing >> 1.
 For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.

 Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
 Transition 00 -> 10: when board == 0 and lives == 3.

 To get the current state, simply do

 board[i][j] & 1
 To get the next state, simply do

 board[i][j] >> 1


 */
public class Game_of_Life {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);

                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Get the 2nd state.
            }
        }
    }

    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }

}
