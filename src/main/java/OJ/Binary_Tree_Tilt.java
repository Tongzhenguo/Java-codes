package OJ;

import datastructure.TreeNode;

/**
 * Created by Tongzhenguo on 2017/7/5.
 * Given a binary tree, return the tilt of the whole tree.

 The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values.
 Null node has tilt 0.

 The tilt of the whole tree is defined as the sum of all nodes' tilt.

 Example:
 Input:
 1
 /   \
 2     3
 Output: 1
 Explanation:
 Tilt of node 2 : 0
 Tilt of node 3 : 0
 Tilt of node 1 : |2-3| = 1
 Tilt of binary tree : 0 + 0 + 1 = 1
 Note:

 The sum of node values in any subtree won't exceed the range of 32-bit integer.
 All the tilt values won't exceed the range of 32-bit integer.
 *
 */
public class Binary_Tree_Tilt {
    int result = 0;

    public int findTilt(TreeNode root) {
        postOrder(root);
        return result;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        result += Math.abs(left - right);

        return left + right + root.val;
    }

}
