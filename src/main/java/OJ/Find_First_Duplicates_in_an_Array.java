package OJ;


/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class Find_First_Duplicates_in_an_Array {

    // 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
    // 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        // 不需要额外的数组或者hash table来保存，题目里写了数组里数字的范围保证在0 ~ n-1 之间，所以可以利用现有数组设置标志，
        // 当一个数字被访问过后，可以**设置这个数字作为下标对应位上的数 + n，之后如果数已经大于等于n了**，那么这个数减n就是第一个重复数。

        if(length == 0){
            duplication[0] = -1;
            return false;
        }
        for(int i=0;i<length;i++){
            if(numbers[i] >= length){
                duplication[0] = numbers[i]-length;
                return true;
            }
            numbers[numbers[i]] += length;
        }
        duplication[0] = -1;
        return false;
    }



    public static void main(String[] args) {
        Find_First_Duplicates_in_an_Array findFirstDuplicatesinanArray = new Find_First_Duplicates_in_an_Array();
        int[] array = {2,4,2,1,4};//{2,4,3,1,4};//{2,1,3,1,4};
        //            {7,5,8,}
        int[] a = new int[1];
        System.out.println(findFirstDuplicatesinanArray.duplicate(array,array.length,a));
        System.out.println(a[0]);
    }

}
