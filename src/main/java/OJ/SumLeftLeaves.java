package OJ;

import datastructure.TreeNode;

/**
 * Created by YYT on 2016/10/24.
 *Find the sum of all left leaves in a given binary tree.

 *Example:

  3
 / \
9   20
   /  \
  15   7

 *There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 *
 */
public class SumLeftLeaves {
    public boolean hasLeftLeave(TreeNode root){
        return root.left != null && (root.left.left == null && root.left.right == null);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root!=null) {
            if (hasLeftLeave(root)) {//有左叶子
                return root.left.val + sumOfLeftLeaves(root.right);
            }//无左子树
            return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
        }else {//空树
            return 0;
        }
    }

    public static void main(String[] args) {
        TreeNode rt = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode node = new TreeNode(4);
        rt.left = left;
        rt.right = right;
        left.left = node;
        SumLeftLeaves o = new SumLeftLeaves();
        System.out.println(o.sumOfLeftLeaves(rt));
    }

}
