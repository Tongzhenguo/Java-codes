package OJ.tree;


import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tongzhenguo on 2019/10/9.
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
 * 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */


public class JZOfferBinTreeSerializeDeserialize {


    // 春天画花卉副校长
    // 先序遍历+递归解法
    public int index = -1;

    String DFSSerialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#!");
            return sb.toString();
        }
        sb.append(root.val + "!");
        sb.append(DFSSerialize(root.left));
        sb.append(DFSSerialize(root.right));
        return sb.toString();
    }
    TreeNode DFSDeserialize(String str) {
        index++;
        int len = str.length();
        if(index >= len){
            return null;
        }
        String[] strr = str.split("!");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = DFSDeserialize(str);
            node.right = DFSDeserialize(str);
        }
        return node;
    }

    // BFS smileit
    String BFSSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null)
            queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(node.val + "!");
            }else{
                sb.append("#" + "!");
            }
        }
        return sb.toString();
    }
    TreeNode BFSDeserialize(String str) {
        TreeNode head = null;
        if(str == null || str.length() == 0)
            return head;
        String[] nodes = str.split("!");
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for(int i=0; i<nodes.length; i++){
            if(!nodes[i].equals("#"))
                treeNodes[i] = new TreeNode(Integer.valueOf(nodes[i]));
        }
        for(int i=0, j=1; j<treeNodes.length; i++){
            if(treeNodes[i] != null){
                treeNodes[i].left = treeNodes[j++];
                treeNodes[i].right = treeNodes[j++];
            }
        }
        return treeNodes[0];
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

        System.out.println(new JZOfferBinTreeSerializeDeserialize().BFSSerialize(root));
    }

}
