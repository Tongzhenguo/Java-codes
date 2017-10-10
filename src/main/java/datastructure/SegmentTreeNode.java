package datastructure;

/**
 * Created by arachis on 2017/10/10.
 */
public class SegmentTreeNode {

    int start, end;
    SegmentTreeNode left, right;
    int sum;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum = 0;
    }
}