package OJ.tree;


import datastructure.TreeNode;

/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferSymmetricalBinaryTree {

    // 请实现一个函数，用来判断一颗二叉树是不是对称的。
    // 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        // 递归的判断左右子树
        return helper(pRoot.left,pRoot.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left != null && right != null && left.val == right.val){
            // 左子树的左对应右子树的右
            // 左子树的右对应右子树的左
            return helper(left.left,right.right) && helper(left.right,right.left);
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(6);
        TreeNode lefta = new TreeNode(5);
        TreeNode leftb = new TreeNode(7);
        TreeNode righta = new TreeNode(7);
        TreeNode rightb = new TreeNode(5);

        root.left = left;
        root.right = right;

        left.left = lefta;
        left.right = leftb;

        right.left = righta;
        right.right = rightb;

        System.out.println(new JZOfferSymmetricalBinaryTree().isSymmetrical(root));
    }

}
