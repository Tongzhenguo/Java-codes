package OJ;

import datastructure.TreeNode;

import java.util.HashMap;

/**
 * Created by arachis on 2017/4/6.
 * The the basic idea is to take the last element in postorder array as the root, find the position of the root in the inorder array;
 * then locate the range for left sub-tree and right sub-tree and do recursion.
 * Use a HashMap to record the index of root in the inorder array.
 * 先从后续遍历中找到根节点，然后在先序遍历中找到对应位置，递归构造左右子树；使用HashMap来记录先序中根节点的索引
 */

public class ConstructBinaryTree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)//使用HashMap来记录先序中各个节点的索引
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0,
                postorder.length-1,hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
                                     HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);//后续的最后一个是根节点
        int ri = hm.get(postorder[pe]);
        TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
        TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }

}
