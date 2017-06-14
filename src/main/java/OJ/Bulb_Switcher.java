package OJ;

/**
 * Created by Tongzhenguo on 2017/6/14.
 There are n bulbs that are initially off.
 You first turn on all the bulbs.
 Then, you turn off every second bulb.
 On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
 For the ith round, you toggle every i bulb.
 For the nth round, you only toggle the last bulb.
 Find how many bulbs are on after n rounds.

 Example:

 Given n = 3.

 At first, the three bulbs are [off, off, off].
 After first round, the three bulbs are [on, on, on].
 After second round, the three bulbs are [on, off, on].
 After third round, the three bulbs are [on, off, off].

 So you should return 1, because there is only one bulb is on.
 */
public class Bulb_Switcher {
    /**
     * A bulb ends up on iff it is switched an odd number of times.
     Call them bulb 1 to bulb n. Bulb i is switched in round d if and only if d divides i.
     So bulb i ends up on if and only if it has an odd number of divisors.
     Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4.
     Except when i is a square, like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, and double divisor 6. So bulb i ends up on if and only if i is a square.

     So just count the square numbers.
     Let R = int(sqrt(n)). That's the root of the largest square in the range [1,n].
     And 1 is the smallest root. So you have the roots from 1 to R, that's R roots. Which correspond to the R squares. So int(sqrt(n)) is the answer.
     (C++ does the conversion to int automatically, because of the specified return type).
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
