package OJ;

/**
 * Created by Tongzhenguo on 2017/6/20.
 * Write a program to find the n-th ugly number.

 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

 牛客网链接：https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b
 LC链接：https://leetcode.com/problems/ugly-number-ii/
 */

public class Ugly_Number_II {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/6aa9e04fc3794f68acf8778237ba065b?f=discussion
     * 来源：牛客网
     *
     * 通俗易懂的解释：
     * 首先从丑数的定义我们知道，一个丑数的因子只有2,3,5，那么丑数p = 2 ^ x * 3 ^ y * 5 ^ z，换句话说一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到，那么我们从1开始乘以2,3,5，就得到2,3,5三个丑数，在从这三个丑数出发乘以2,3,5就得到4，6,10,6，9,15,10,15,25九个丑数，我们发现这种方法会得到重复的丑数，而且我们题目要求第N个丑数，这样的方法得到的丑数也是无序的。那么我们可以维护三个队列：
     * （1）丑数数组： 1
     * 乘以2的队列：2
     * 乘以3的队列：3
     * 乘以5的队列：5
     * 选择三个队列头最小的数2加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
     * （2）丑数数组：1,2
     * 乘以2的队列：4
     * 乘以3的队列：3，6
     * 乘以5的队列：5，10
     * 选择三个队列头最小的数3加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
     * （3）丑数数组：1,2,3
     * 乘以2的队列：4,6
     * 乘以3的队列：6,9
     * 乘以5的队列：5,10,15
     * 选择三个队列头里最小的数4加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
     * （4）丑数数组：1,2,3,4
     * 乘以2的队列：6，8
     * 乘以3的队列：6,9,12
     * 乘以5的队列：5,10,15,20
     * 选择三个队列头里最小的数5加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
     * （5）丑数数组：1,2,3,4,5
     * 乘以2的队列：6,8,10，
     * 乘以3的队列：6,9,12,15
     * 乘以5的队列：10,15,20,25
     * 选择三个队列头里最小的数6加入丑数数组，但我们发现，有两个队列头都为6，所以我们弹出两个队列头，同时将12,18,30放入三个队列；
     */
    public int nthUglyNumber(int n) {
        //        链接：https://www.nowcoder.com/questionTerminal/6aa9e04fc3794f68acf8778237ba065b?f=discussion
//        来源：牛客网
        // 0-6的丑数分别为0-6
        if(n < 7) return n;
//        ArrayList<Integer> list=new ArrayList<Integer>();
        // 因为每次只选择一个最小的数，所以该用数组和for循环(最大循环次数就是n)
        int[] uglyArray = new int[n+1];
        //i2，i3，i5分别为三个队列的指针，newNum为从队列头选出来的最小数
        int i2=0,i3=0,i5=0,currMin=1;
        uglyArray[0]=1;
        for(int i=1;i<n;i++)
        {
            int m2=uglyArray[i2]*2;
            int m3=uglyArray[i3]*3;
            int m5=uglyArray[i5]*5;
            // 选出三个队列头最小的数
            currMin=Math.min(m2,Math.min(m3,m5));
            // 有序加入list中
            uglyArray[i]=currMin;
            // 这三个if有可能进入一个或者多个，进入多个是三个队列头最小的数有多个的情况
            if(currMin==m2)i2++;
            if(currMin==m3)i3++;
            if(currMin==m5)i5++;
        }
        return uglyArray[n-1];
    }


}
