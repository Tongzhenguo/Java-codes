package OJ;

/**
 * Created by arachis on 2017/10/19.
 * In the "100 game," two players take turns adding, to a running total, any integer from 1..10.
 * The player who first causes the running total to reach or exceed 100 wins.
 * <p/>
 * What if we change the game so that players cannot re-use integers?
 * <p/>
 * For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.
 * <p/>
 * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.
 * <p/>
 * You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
 * <p/>
 * Example
 * <p/>
 * Input:
 * maxChoosableInteger = 10
 * desiredTotal = 11
 * <p/>
 * Output:
 * false
 * <p/>
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 * Same with other integers chosen by the first player, the second player will always win.
 */
public class Can_I_Win {
    //https://discuss.leetcode.com/topic/68896/java-solution-using-hashmap-with-detailed-explanation
    private Boolean[] win;
    int choosen = 0;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        win = new Boolean[1 << maxChoosableInteger];
        return canWin(maxChoosableInteger, desiredTotal, 0);
    }

    private boolean canWin(int n, int total, int now) {
        if (win[choosen] != null)
            return win[choosen];
        if (now >= total) {
            win[choosen] = false;
            return false;
        }
        for (int i = 1; i <= n; i++) {
            int bit = 1 << (i - 1);
            if ((choosen & bit) == 0) {
                choosen ^= bit;
                boolean ulose = !canWin(n, total, now + i);
                choosen ^= bit;

                if (ulose) {
                    win[choosen] = true;
                    return true;
                }
            }
        }
        win[choosen] = false;
        return false;
    }

}
