package OJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arachis on 2017/4/23.
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 一个有序的整型数组，不存在重复，设计算法求返回各个区段范围的值
 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class Summary_Ranges {

    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList();

        for(int i=0;i<nums.length;i++){
            if(nums.length==1){
                list.add(nums[0]+"");
                break;
            }else{
                int a=nums[i];
                while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
                    i+=1;
                }
                if(a!=nums[i]){
                    list.add(a+"->"+nums[i]);
                }else{
                    list.add(a+"");
                }
            }
        }
        return list;
    }

}
