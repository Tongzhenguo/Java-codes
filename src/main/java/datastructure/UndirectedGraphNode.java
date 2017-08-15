package datastructure;

/**
 * Created by arachis on 2017/8/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for undirected graph.
 *  */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public Integer label;

    public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
