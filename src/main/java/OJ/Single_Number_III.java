package OJ;

/**
 * Created by arachis on 2017/10/3.
 *
 * Given an array of numbers nums,
 * in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

 For example:
 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 返回数组的先后顺序不影响
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 要求算法时间复杂度为O(n),空间复杂度为O(1)
 */
public class Single_Number_III {

    // 异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
    // 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。

    // 首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。
    // 然后根据刚刚异或结果中1的位数分成两组，把这两个组依次异或，剩余的两个结果就是这两个只出现一次的数字。
    public int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }

    // 异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
    // 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。

    // 首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。
    // 然后根据刚刚异或结果中1的位数分成两组，把这两个组依次异或，剩余的两个结果就是这两个只出现一次的数字。
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        int xor1 = 0;
        for(int i=0; i < array.length; i++)
            xor1 = xor1^array[i];
        //在xor1中找到第一个不同的位对数据进行分类，分类为两个队列对数据进行异或求和找到我们想要的结果
        int index = 1;
        while((index & xor1)==0)
            index = index <<1;//因为可能有多个位为1所以需要求一下位置
        int result1 = 0;
        int result2 = 0;
        for(int i=0; i < array.length; i++){
            if((index & array[i]) == 0)
                result1 = result1^array[i];
            else
                result2 = result2^array[i];
        }
        num1[0] = result1;
        num2[0] = result2;
    }

}
