package OJ;

/**
 * Created by arachis on 2017/4/26.
 * A peak element is an element that is greater than its neighbors.
 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 给一个数组，返回数组中的局部最大值（峰值）对应的索引；你可以假定开始和结尾的元素是负无穷
 *
 */
public class Find_Peak_Element {
    public int findPeakElement(int[] num) {
        return helper(num,0,num.length-1);
    }

    public int helper(int[] num,int start,int end){
        if(start == end){
            return start;
        }else if(start+1 == end){
            if(num[start] > num[end]) return start;
            return end;
        }else{

            int m = (start+end)/2;

            if(num[m] > num[m-1] && num[m] > num[m+1]){
                //If num[i-1] < num[i] > num[i+1], then num[i] is peak
                return m;
            }else if(num[m-1] > num[m] && num[m] > num[m+1]){
                //  If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
                return helper(num,start,m-1);
            }else{
                //If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
                //If num[i-1] > num[i] < num[i+1], then both sides have peak,选择右边的peak
                return helper(num,m+1,end);
            }

        }
    }


}
