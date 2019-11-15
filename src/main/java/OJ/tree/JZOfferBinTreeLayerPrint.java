package OJ.tree;


import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferBinTreeLayerPrint {

    // 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot == null){
            return new ArrayList<ArrayList<Integer>>();
        }
        // LinkedList实现队列，缓存待遍历的结点
        LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
        // LinkedList实现队列，缓存待遍历的结点
        LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        queue1.add(pRoot);
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            if(!queue1.isEmpty() ){
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (!queue1.isEmpty()){
                    TreeNode node = queue1.poll();
                    arrayList.add(node.val);
                    if(node.left!=null){
                        queue2.add(node.left);
                    }
                    if(node.right!=null){
                        queue2.add(node.right);
                    }
                }
                list.add(arrayList);
            }else{
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (!queue2.isEmpty()){
                    TreeNode node = queue2.poll();
                    arrayList.add(node.val);
                    if(node.left!=null){
                        queue1.add(node.left);
                    }
                    if(node.right!=null){
                        queue1.add(node.right);
                    }
                }
                list.add(arrayList);
            }
        }
        return list;
    }

    // spursKawhi 较短代码的递归解法
    ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root == null) return;
        if(depth > list.size())
            list.add(new ArrayList<Integer>());
        list.get(depth -1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
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

        ArrayList<ArrayList<Integer>> arrayLists = new JZOfferBinTreeLayerPrint().Print(root);
        for (int i = 0; i < arrayLists.size(); i++) {
            for (int j = 0; j < arrayLists.get(i).size(); j++) {
                System.out.print(arrayLists.get(i).get(j)+",");
            }
            System.out.println();
        }
        System.out.println(arrayLists);
    }

}
