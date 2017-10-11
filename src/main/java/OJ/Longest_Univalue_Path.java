package OJ;

import datastructure.TreeNode;

/**
 * Created by arachis on 2017/10/11.
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 * <p/>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * <p/>
 * Example 1:
 * <p/>
 * Input:
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * Output:
 * 2
 * <p/>
 * Example 2:
 * Input:
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * Output:
 * 2
 */
public class Longest_Univalue_Path {

    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        if (root != null) dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        int l = node.left != null ? dfs(node.left, res) : 0;
        int r = node.right != null ? dfs(node.right, res) : 0;
        int resl = node.left != null && node.left.val == node.val ? l + 1 : 0;
        int resr = node.right != null && node.right.val == node.val ? r + 1 : 0;
        res[0] = Math.max(res[0], resl + resr);
        return Math.max(resl, resr);
    }
}
