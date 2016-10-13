package OJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Administrator on 2016/10/11.
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board（9*9） could be partially filled, where empty cells are filled with the character '.'.
 */
public class ValidSudoku {
/*    public boolean isValidSudoku(char[][] board) {
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
    }*/
    /**
     * 有一种解法：
     *     1，将遍历到的数据存到向量中，如果出现过就返回
     *     2，表示小九宫格可以用Map（i/3-j/3,Vector）存储
     *         i/3“-”j/3标识唯一一个九宫格
     */
    public boolean isValidSudoku(char[][] board) {
        // 存储行列以及小九宫格的数字
        Vector<Integer> row = new Vector<Integer>(9);
        Vector<Integer> col = new Vector<Integer>(9);
        String sign;
        Map<String,Vector<Integer>> zone = new HashMap<String, Vector<Integer>>(9){{
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    Vector<Integer> vector = new Vector<Integer>(9);
                    put(i/3+"-"+j/3, vector);
                }
            }

        }};
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int num= board[i][j] - '0';
                sign = i/3 + "-" +j/3;
                if(row.contains(num) || col.contains(num) || zone.get(sign).contains(num)){
                    return false;
                }
                if(num!='.'){
                    row.add(board[i][j]-'0');
                    col.add(board[j][i]-'0');
                    zone.get(sign).add(board[i][j]-'0');
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku sudu = new ValidSudoku();
        char[][] chars = new char[9][9];
        for(int i=0;i<9;i++){
            if(i ==0){
                for(int j=0;j<9;j++) {
                    if(j==0){
                        chars[i][j] = '.';
                        System.out.print(chars[i][j]);
                    }else {
                        chars[i][j] = (char) (9 - j + '0');
                        System.out.print(chars[i][j]);
                    }
                }
                System.out.println();
            }
            for(int j=0;j<9;j++) {
                if(j == 0) {
                    chars[i][0] = (char) ('0' + i + 1);
                    System.out.print(chars[i][j]);
                }
                else{
                    chars[i][j] = '.';
                    System.out.print(chars[i][j]);
                }
            }
            System.out.println();
            }

        System.out.println(sudu.isValidSudoku(chars));
    }
}
