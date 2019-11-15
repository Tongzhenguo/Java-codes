package OJ.tree;


import datastructure.TreeLinkNode;

/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferBinTreeNext {

    // 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
    // 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 注意这里给的是任意一个结点，需要多考虑几种情况
        if(pNode.right != null){
            // 如果存在右子树，则找右子树最左的元素
            pNode = pNode.right;
            while (pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }else{
            // 如果不存在右子树，节点不是根节点,使用回溯非递归算法
            while (pNode.next != null){
                if(pNode.next.left == pNode){
                    return pNode.next;
                }
                pNode = pNode.next;
            }
        // 回溯到了根结点，但给定结点属于根结点的右孩子，返回空
        return null;
     }
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
//        TreeNode node = new JZOfferBinTreeNext().Convert(root);
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
