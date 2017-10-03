package OJ;

/**
 * Created by arachis on 2017/10/3.
 *
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Single_Number_II {
 /**
  * 输入是int型数组，所以可以用32位来表达输入数组的元素。
  假设输入中没有single number，那么输入中的每个数字都重复出现了数字，也就是说，对这32位中的每一位i而言，所有的输入加起来之后，第i位一定是3的倍数。
  现在增加了single number，那么对这32位中的每一位做相同的处理，也就是说，逐位把所有的输入加起来，除以3的余数就是single numer在第i位的取值。这样就得到了single number在第i位的取值。
  这等价于一个模拟的二进制，接着只需要把这个模拟的二进制转化为十进制输出即可。
  为了完成上面的过程，需要使用一个数组 int a[ 32 ]来模拟位运算。
  另外，这个做法可以扩展，如果有一堆输入，其中1个数字出现了1次，剩下的数字出现了K次，这样的问题全部可以使用这样的办法来做。
  */
 public int singleNumber(int[] nums) {
   int[] count = new int[32];int n = nums.length;
   int result=0;
   for(int i=0;i<32;i++){
         for(int j=0;j<n;j++){
          count[i]+=((nums[j]>>i)&1); //首先把输入数字的第i位加起来。
          count[i]=count[i]%3; //然后求它们除以3的余数。
         }
    result|=(count[i]<<i);//把二进制表示的结果转化为十进制表示的结果
   }
   return result;
 }


}
