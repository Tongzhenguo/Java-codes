package OJ.math;


/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferIsContinuous {

    // 大小王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
    // 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何
    // 如果牌能组成顺子就输出true，否则就输出false。
    // 为了方便起见,你可以认为大小王是0。
    public boolean isContinuous(int [] numbers) {
        //max 记录 最大值
        //min 记录 最小值
        //min,max 都不记0
        //满足条件
        //  1 max - min <5
        //  2 除0外没有重复的数字(牌)
        //  3 数组长度 为5

        // 不满足条件3
        if(numbers.length < 5){
            return false;
        }
        int[]d = new int[14];
        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for(int i =0;i<len;i++){
            d[numbers[i]]++;
            if(numbers[i] == 0){
                continue;
            }
            // 重复，不满足条件2
            if(d[numbers[i]]>1){
                return false;
            }
            if(numbers[i] >max){
                max = numbers[i];
            }
            if(numbers[i] <min){
                min = numbers[i];
            }

        }
        // 不满足条件1
        if(max-min>=5){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] a = {1,3,2,6,4};
        System.out.println(new JZOfferIsContinuous().isContinuous(a));
//        System.out.println(new JZOfferIsContinuous().isContinuous());

    }

}
