package OJ;

import datastructure.TreeNode;
import java.util.Stack;

/**
 * Created by Tongzhenguo on 2017/7/12.
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

 */
public class BSTIterator {
    /*
    * My idea comes from this:
    * My first thought was to use inorder traversal to put every node into an array, and then make an index pointer for the next() and hasNext().
    * That meets the O(1) run time but not the O(h) memory. O(h) is really much more less than O(n) when the tree is huge.
    *
    * Since the TreeNode doesn't have father pointer, we cannot get a TreeNode's father node in O(1) without store it beforehand.
     * Back to the first step, when we are traversal to the left most TreeNode, we store each TreeNode we met ( They are all father nodes for back trace).
    * */
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            if(cur.left != null)
                cur = cur.left;
            else
                break;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        // traversal right branch
        if(cur.right != null){
            cur = cur.right;
            while(cur != null){
                stack.push(cur);
                if(cur.left != null)
                    cur = cur.left;
                else
                    break;
            }
        }
        return node.val;
    }


    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */
}
