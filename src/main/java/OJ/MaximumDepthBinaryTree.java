package OJ;

import datastructure.TreeNode;

/**
 * Created by Administrator on 2016/10/16.
 * Given a binary tree, find its maximum depth.
 */
public class MaximumDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        else{
            return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
        }
    }
}
