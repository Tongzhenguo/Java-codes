package OJ.tree;


import datastructure.TreeNode;

/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferTreeLinkNodeNext {

    // 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    // 要求不能创建任何新的结点，只能调整树中结点指针的指向。
    public TreeNode Convert(TreeNode pRootOfTree) {
        // 搜索二叉树中序遍历的性质：结果是一个非递减的序列
        // pre和left指针一致；next和right指针一致
        if(pRootOfTree == null){
            return null;
        }
        TreeNode pre = null;
        if(pRootOfTree.left != null){
            // 若当前节点有左子树，寻找左子树的最右元素，即为当前节点的前驱。
            pre = pRootOfTree.left;
            while (pre.right != null){
                pre = pre.right;
            }
        }
        pRootOfTree.left = pre;
        TreeNode next = null;
        if(pRootOfTree.right != null){
            // 若当前节点有右子树，寻找右子树的最左元素，即为当前节点的后继。
            next = pRootOfTree.right;
            while (next.left != null){
                next = next.left;
            }
        }
        pRootOfTree.right = next;
        Convert(pRootOfTree.left);
        Convert(pRootOfTree.right);
        return pRootOfTree;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(1);

        root.left = a1;
        a1.left = a2;

//        root.left = left;
//        root.right = right;

        TreeNode node = new JZOfferTreeLinkNodeNext().Convert(root);
        TreeNode p = node;
        while (p != null){
            System.out.println(p.val);
            p = p.right;
        }
        System.out.println("------");
        p = node;
        while (p != null){
            System.out.println(p.val);
            p = p.left;
        }
    }

}
