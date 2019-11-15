package OJ.tree;


import java.util.Arrays;

/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferVerifySquenceOfBST {

    // 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    // 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
    public boolean VerifySquenceOfBST(int [] sequence) {
        // 二叉搜索树的后序遍历：左右根
        if(sequence.length == 0){
            return false;
        }
        if(sequence.length == 1){
            return true;
        }
        int mid = 0;
        // 找到左子树的最右边叶子
        while(sequence[mid]<sequence[sequence.length-1]){
            mid ++;
        }
        int k = mid;
        while (k<sequence.length-1){
            // 反序退出
            if(sequence[k]<sequence[sequence.length-1]){
                return false;
            }
            k++;
        }
        // 递归的左右也满足
        VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,mid));
        VerifySquenceOfBST(Arrays.copyOfRange(sequence,mid,sequence.length-1));
        return true;
    }

    public static void main(String[] args) {
        int[] array = {4,8,6,12,16,14,10};
        System.out.println(new JZOfferVerifySquenceOfBST().VerifySquenceOfBST(array));
    }

}
