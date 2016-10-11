package OJ;

/**
 * Created by Administrator on 2016/10/11.
 *
 * You are playing the following Nim Game with your friend:
 * There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones.
 * The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 * Both of you are very clever and have optimal strategies for the game.
 * Write a function to determine whether you can win the game given the number of stones in the heap.
 * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove,
 * the last stone will always be removed by your friend.
 * 翻译过来就是给两人一堆石头，由你开始两人轮流拿一到三块石头，谁最后拿不到石头为输；
 * 写一个函数，判断给定石头数n,你是否能赢
 */
public class NimGame {
    /**
     * 思路：
     *  明显我拿完之后，剩下四或四的倍数，则我赢
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        boolean win = false;
        for(int i=1;i<4;i++){
            if( (n-i) %4 == 0){
                win = true;
                break;
            }
        }
        return win;
    }

    public static void main(String[] args) {
        NimGame game = new NimGame();
        System.out.println(game.canWinNim(4));
        System.out.println(game.canWinNim(7));
        System.out.println(game.canWinNim(5));
    }

}
