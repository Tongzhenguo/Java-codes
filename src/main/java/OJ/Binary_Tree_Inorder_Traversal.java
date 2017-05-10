package OJ;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tongzhenguo on 2017/5/10.
 * Given a binary tree, return the inorder traversal of its nodes' values.
 返回一颗二叉树中序遍历的结果
 For example:
 Given binary tree [1,null,2,3],
 1
 \
 2
 /
 3
 return [1,3,2].
 *
 */
public class Binary_Tree_Inorder_Traversal {

    public void help( TreeNode root, List<Integer> list ){
        if( root!= null ){

            help(root.left,list );
            list.add( root.val );
            help( root.right,list );

        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        if( root == null )
            return list;

        help( root,list );

        return list;

    }


}
