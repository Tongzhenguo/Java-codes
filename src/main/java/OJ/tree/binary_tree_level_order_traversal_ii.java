package OJ.tree;

/**
 * Created by tongzhenguo on 2019/11/17.
 */

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class binary_tree_level_order_traversal_ii {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        queue.add(root);
        while(queue.size()>0){
            int layerNums = queue.size();
            list.add(new ArrayList<Integer>(layerNums));
            ArrayList<Integer> vals = new ArrayList<Integer>(layerNums);
            for(int i=0;i<layerNums;i++){
                TreeNode node = queue.poll();
                vals.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(vals);
        }
        // 原地算法,size小于18,底层实现是直接swap上下元素
        Collections.reverse(list);
        return list;
    }

}
