package OJ.tree;


import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferBinTreeZPrint {

    // 请实现一个函数按照之字形打印二叉树，
    // 即第一行按照从左到右的顺序打印
    // 第二层按照从右至左的顺序打印，
    // 第三行按照从左到右的顺序打印，其他行以此类推。
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //s1存奇数层节点
        //s2存偶数层节点
        // 最开始是1层，s1存root；
        // s1出栈root，s2入栈左右结点。记录root的值
        // s2出栈上一层结点，相应孩子结点入栈s1,记录出栈结点的值。
        // 当s1,s2栈都为空时，遍历结束。
        if(pRoot == null){
            return new ArrayList<ArrayList<Integer>>();
        }
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        s1.push(pRoot);
        while (! s1.empty() || ! s2.empty()){
            if(! s1.empty()){
                // 奇数层s1从左往右输出，所以只要s2保证从右往左入栈就可以
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (! s1.empty()){
                    TreeNode node = s1.pop();
                    list.add(node.val);
                    if(node.left!=null){
                        s2.push(node.left);
                    }
                    if(node.right!=null){
                        s2.push(node.right);
                    }
                }
                result.add(list);
            }else{
                // 偶数层s2从右往左输出，所以只要s1保证从左往右入栈就可以
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (! s2.empty()){
                    TreeNode node = s2.pop();
                    list.add(node.val);
                    if(node.right!=null){
                        s1.push(node.right);
                    }
                    if(node.left!=null){
                        s1.push(node.left);
                    }
                }
                result.add(list);
            }
        }
        return result;
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

        // 正确case的结果应该是奇数层是升序
        // 偶数层是降序
        ArrayList<ArrayList<Integer>> arrayLists = new JZOfferBinTreeZPrint().Print(root);
        for (int i = 0; i < arrayLists.size(); i++) {
            for (int j = 0; j < arrayLists.get(i).size(); j++) {
                System.out.print(arrayLists.get(i).get(j)+",");
            }
            System.out.println();
        }
        System.out.println(arrayLists);
    }

}
