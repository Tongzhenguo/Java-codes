package OJ;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tongzhenguo on 2017/7/20.
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class Unique_Binary_Search_Trees_II {

    public List<TreeNode> generateTrees(int n) {

        return genTrees(1,n);
    }

    /**
     * I start by noting that 1..n is the in-order traversal for any BST with nodes 1 to n.
     * So if I pick i-th node as my root, the left subtree will contain elements 1 to (i-1), and the right subtree will contain elements (i+1) to n.
     * I use recursive calls to get back all possible trees for left and right subtrees and combine them in all possible ways with the root.
     */
    public List<TreeNode> genTrees (int start, int end) {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start>end) {
//            list.add(null);
            return list;
        }

        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left,right;
        for(int i=start;i<=end;i++) {

            left = genTrees(start, i-1);
            right = genTrees(i+1,end);

            for(TreeNode lnode: left) {
                for(TreeNode rnode: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }

        return list;
    }
//    Input:
//            3
//    Output:
//            [[2,1,3]]
//    Expected:
//            [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

}
