package OJ;

import datastructure.TreeNode;

/**
 * Created by YYT on 2016/10/19.
 *   4
 /   \
 2     7
 / \   / \
 1   3 6   9
 to
 4
 /   \
 7     2
 / \   / \
 9   6 3   1

 简单讲就是将树的所有分支，左右互换
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        /**
         * 网上看到的方法
         */
        if(root == null ){
            return root;
        }
        if(root.left!=null && root.right!=null) {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode rt = new TreeNode(442);
        TreeNode left = new TreeNode(443);
        TreeNode right = new TreeNode(444);
        TreeNode node = new TreeNode(445);
        rt.left = left;
        rt.right = right;
        rt.left.left = node;

        System.out.println(new InvertBinaryTree().invertTree(rt).right.left.val);
    }
}
