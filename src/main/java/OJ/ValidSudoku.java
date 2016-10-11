package OJ;

/**
 * Created by Administrator on 2016/10/11.
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board（9*9） could be partially filled, where empty cells are filled with the character '.'.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //每一行每一列每一宫都有数字且不重复 由此设置三个数组来判断
        boolean [][]row = new boolean[9][9];
        boolean [][]col = new boolean[9][9];
        boolean [][]block = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.')continue;
                int num = board[i][j]-'1';//charToInt
                if(row[num][i]||col[num][j]||block[num][i-i%3+j/3]){
                    return false;
                }
                //表示出现过
                row[num][i]=col[num][j]=block[num][i-i%3+j/3]=true;
            }
        }
        return true;
    }
}
