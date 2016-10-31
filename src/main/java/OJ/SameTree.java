package OJ;

import datastructure.TreeNode;

/**
 * Created by YYT on 2016/10/31.
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 简单的说就是判断两颗二叉树是不是完全相同
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean flag = true;
        if(p == null && q == null || p == q){ //空值处理,引用相同
            return true;
        }else if( (p != null&& q == null) || (q != null && p == null) )  {
            return false;
        } //都不为空
        if(p.val != q.val){
            flag = false;
            return flag;
        }else {
            boolean sameTreeleft = isSameTree(p.left, q.left);
            boolean sameTreeright = isSameTree(p.right, q.right);
            return flag && sameTreeleft && sameTreeright;
        }
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


        SameTree o = new SameTree();
        System.out.println(o.isSameTree(rt,rt1));
    }
}
