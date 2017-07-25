package OJ;

import datastructure.TreeNode;

/**
 * Created by Tongzhenguo on 2017/7/25.
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:
 3
 / \
 2   3
 \   \
 3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 Example 2:
 3
 / \
 4   5
 / \   \
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 */
public class House_Robber_III {
    /**
     If we were able to maintain the information about the two scenarios for each tree root, let's see how it plays out.
     Redefine rob(root) as a new function which will return an array of two elements,
     the first element of which denotes the maximum amount of money that can be robbed if root is not robbed,
     while the second element signifies the maximum amount of money robbed if it is robbed.

     Let's relate rob(root) to rob(root.left) and rob(root.right)..., etc.
     For the 1st element of rob(root), we only need to sum up the larger elements of rob(root.left) and rob(root.right),
     respectively, since root is not robbed and we are free to rob its left and right subtrees. For the 2nd element of rob(root),
     however, we only need to add up the 1st elements of rob(root.left) and rob(root.right),
     respectively, plus the value robbed from root itself, since in this case it's guaranteed that we cannot rob the nodes of root.left and root.right.

     by keeping track of the information of both scenarios, we decoupled the subproblems and the solution essentially boiled down to a greedy one.
     */
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }



}
