package OJ.tree;

import datastructure.TreeNode;

/**
 * https://leetcode-cn.com/problems/same-tree/
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 */
public class Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 双指针，递归地比较两个树结点的结构和值
        if(p == null && q == null){
            return true;
        }
        // bfs,二叉树的先序遍历
        if(p != null && q != null && p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode rt = new TreeNode(442);
        TreeNode left = new TreeNode(443);
        TreeNode right = new TreeNode(444);
        TreeNode node = new TreeNode(445);
        left.left = node;
        rt.left = left;
        rt.right = right;

        TreeNode rt1 = new TreeNode(442);
        TreeNode left1 = new TreeNode(443);
        TreeNode right1 = new TreeNode(444);
        rt1.left = left1;
        rt1.right = right1;


        Same_Tree o = new Same_Tree();
        System.out.println(o.isSameTree(rt,rt1));
    }
}
