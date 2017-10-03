package OJ;

/**
 * Created by arachis on 2017/10/3.
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 For example, given the range [5, 7], you should return 4.
 */
public class Bitwise_AND_of_Numbers_Range {
    /**
     * The idea is very simple:
        last bit of (odd number & even number) is 0.
        when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
        Move m and n rigth a position.
        Keep doing step 1,2,3 until m equal to n, use a factor to record the iteration time.
     */
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }

}
