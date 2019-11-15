package OJ.divideconquer;


import java.util.ArrayList;

/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferTwoSumInSotredArray {
    // 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
    // 对应每个测试案例，输出两个数，小的先输出。
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

        /*
        (1)输出两个数的乘积最小的。这句话的理解？
        假设：若b>a,且存在，
        a + b = s;
        (a - m ) + (b + m) = s
        则：(a - m )(b + m)=ab - (b-a)m - m*m < ab；说明外层的乘积更小

        (2)左右夹逼法！！！只需要2个指针
        1.left开头，right指向结尾
        2.如果和小于sum，说明太小了，left右移寻找更大的数
        3.如果和大于sum，说明太大了，right左移寻找更小的数
        4.和相等，把left和right的数返回
        */

        if(array.length<2 || sum<array[0]+array[1] || sum>array[array.length-2]+array[array.length-1]){
            return new ArrayList<Integer>();
        }
        //存放结果
        ArrayList<Integer> result = new ArrayList<>();
        // 对撞指针
        int left = 0;
        int right = array.length -1;
        while(left<right){
            if(array[left]+array[right]==sum){
                result.add(array[left]);
                result.add(array[right]);
                return result;
            }else if(array[left]+array[right]>sum){
                right--;
            }else{
                left++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = {1,2,4,7,11,15};
        System.out.println(new JZOfferTwoSumInSotredArray().FindNumbersWithSum(array,15));
    }

}
