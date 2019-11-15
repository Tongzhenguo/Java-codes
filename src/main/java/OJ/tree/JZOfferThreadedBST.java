package OJ.tree;

import datastructure.TreeNode;

/**
 * Created by tongzhenguo on 2019/11/15.
 */
public class JZOfferThreadedBST {

    // 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    // 要求不能创建任何新的结点，只能调整树中结点指针的指向。
    public TreeNode Convert(TreeNode pRootOfTree) {
        /**
         *
         * 解题思路：
         * 1.将左子树构造成双链表，并返回链表头节点。
         * 2.定位至左子树双链表最后一个节点。
         * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。
         * 4.将右子树构造成双链表，并返回链表头节点。
         * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
         * 6.根据左子树链表是否为空确定返回的节点。
         */

        if(pRootOfTree == null){
            return null;
        }
        // 将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        // 如果左子树链表不为空的话，将当前root追加到左子树链表。
        if(left != null){
            // 若当前节点有左子树，寻找左子树的最右元素，即为当前节点的前驱。
            TreeNode leftMax = left;
            while (leftMax.right !=null){
                leftMax = leftMax.right;
            }
            leftMax.right = pRootOfTree;
            pRootOfTree.left = leftMax;
        }
        // 将右子树构造成双链表，并返回链表头节点。
        TreeNode right = Convert(pRootOfTree.right);
        // 如果右子树链表不为空的话，将该链表追加到root节点之后。
        if(right != null){
            // 若当前节点有右子树，寻找右子树的最左元素，即为当前节点的后继。
            TreeNode rightMin = right;
            while (rightMin.left != null){
                rightMin = rightMin.left;
            }
            rightMin.left = pRootOfTree;
            pRootOfTree.right = rightMin;
        }
        // 根据左子树链表是否为空确定返回的节点。
        return left==null?pRootOfTree:left;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        TreeNode a1 = new TreeNode(2);
//        TreeNode a2 = new TreeNode(1);
//
//        root.left = a1;
//        a1.left = a2;
//
////        root.left = left;
////        root.right = right;
//
//        TreeNode node = new ().Convert(root);
//        TreeNode p = node;
//        System.out.println(p.val);
//        while (p.right != null){
//            System.out.println(p.right.val);
//            p = p.right;
//        }
//        System.out.println("------");
//        while (p != null){
//            System.out.println(p.val);
//            p = p.left;
//        }
    }

}
