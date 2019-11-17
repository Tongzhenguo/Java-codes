package OJ.tree;

import datastructure.TreeNode;

/**
 * Created by tongzhenguo on 2019/11/17.
 */
public class convert_sorted_array_to_binary_search_tree {

    public TreeNode sortedArrayToBST(int[] nums) {
        // 递归的划分二叉搜索树
        // 根结点的选取，当偶数时规定(left+right)/2为根结点
        if(nums.length==0){
            return null;
        }
        // 只传递引用可以节省空间，不必递归地创建一个数组,时间空间消耗降低
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);
        return root;
    }

}
