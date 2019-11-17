package OJ.tree;


import datastructure.TreeNode;

import java.util.LinkedList;

/**
 * Created by tongzhenguo on 2019/10/9.
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 给定一个二叉树，检查它是否是镜像对称的
 * 说明:如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */


public class JZOfferSymmetricalBinaryTree {

    // 递归方法
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

    // 迭代方法
    // 可以利用队列进行迭代。该算法的工作原理类似于 BFS，
    // 但存在一些关键差异。每次提取两个结点并比较它们的值。
    // 然后，将两个结点的左右子结点按相反的顺序插入队列中。
    // 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
    public boolean isSymmetric(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return true;
        }
        LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(root.left);
        queue2.add(root.right);
        while(!queue1.isEmpty() || !queue2.isEmpty()){
            TreeNode left = queue1.poll();
            TreeNode right = queue2.poll();
            if(left != null && right != null){
                if(left.val != right.val){
                    return false;
                }
                // 左左对比右右
                queue1.add(left.left);
                queue2.add(right.right);
                // 左右对比右左
                queue1.add(left.right);
                queue2.add(right.left);
            }else if(left == null && right == null){
                continue;
            }else{
                return false;
            }
        }
        return true;
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
