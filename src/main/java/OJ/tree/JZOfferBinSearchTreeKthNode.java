package OJ.tree;


import datastructure.TreeNode;

import java.util.Stack;

/**
 * Created by tongzhenguo on 2019/10/9.
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 */


public class JZOfferBinSearchTreeKthNode {

    // 递归解法
    int index = 0; //计数器
    TreeNode KthNodeRecursion(TreeNode root, int k){
        if(root != null){ //中序遍历寻找第k个
            TreeNode node = KthNodeRecursion(root.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return root;
            node = KthNodeRecursion(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }
    // 非递归解法
    TreeNode KthNodeNoRecursion(TreeNode root, int k){
        if(root==null||k==0)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count = 0;
        TreeNode node = root;
        stack.push(node);
        node = node.left;
        while(node!=null||!stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                count++;
                if(count==k)
                    return node;
                node = node.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // 二叉搜索树
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(10);
        TreeNode lefta = new TreeNode(1);
        TreeNode leftb = new TreeNode(4);
        TreeNode righta = new TreeNode(7);
        TreeNode rightb = new TreeNode(12);

        root.left = left;
        root.right = right;

        left.left = lefta;
        left.right = leftb;

        right.left = righta;
        right.right = rightb;
        // 1,3,4,5,7,10,12
//        System.out.println(new JZOfferBinSearchTreeKthNode().KthNode(root,1).val);
//        System.out.println(new JZOfferBinSearchTreeKthNode().KthNode(root,2).val);
//        System.out.println(new JZOfferBinSearchTreeKthNode().KthNode(root,3).val);
    }

}
