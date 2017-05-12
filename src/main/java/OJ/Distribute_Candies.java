package OJ;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Tongzhenguo on 2017/5/12.
 *
 Given an integer array with even length, where different numbers in this array represent different kinds of candies.
 Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister.
 Return the maximum number of kinds of candies the sister could gain.
一个偶数长度的整型数组，每一个数字代表一类巧克力，设计算法平均分发这些巧克力给两个孩子，求一个孩子能获得的最多巧克力种数　
 Example 1:
 Input: candies = [1,1,2,2,3,3]
 Output: 3
 Explanation:
 There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 The sister has three different kinds of candies.
 Example 2:
 Input: candies = [1,1,2,3]
 Output: 2
 Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 The sister has two different kinds of candies, the brother has only one kind of candies.
 */
public class Distribute_Candies {

    public int distributeCandies(int[] candies) {

        HashSet<Integer> set = new HashSet<Integer>();
        for( Integer i:candies ){
            set.add( i );
        }
        return  Math.min( candies.length / 2,set.size() );

    }

}

