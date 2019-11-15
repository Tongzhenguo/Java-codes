package OJ.lineartable;


import datastructure.ListNode;

/**
 * Created by tongzhenguo on 2019/9/6.
 */


public class JZOfferFindFirstCommonNode {
    // 输入两个链表，找出它们的第一个公共结点。


    // 链接：https://blog.nowcoder.net/n/8cbed9b696b4457a85c186d209a683c6?f=comment
    // 来源：牛客网
    //
    // 首先我们要知道什么是公共节点，两个链表从某一节点开始，他们的next都指向同一个节点。
    // 但由于是单向链表的节点，每个节点只有一个next，因此从第一个公共节点开始，之后他们的所有节点都是重合的，不可能再出现分叉。

    // 遍历两遍这两个链表，如果有重复的节点，那么一定能够使遍历的指针相等。
    // 代码的ifelse语句，对于某个指针p1来说，其实就是让它跑了连接好的的链表，长度就变成一样了。
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) p1 = pHead2;
                if (p2 == null) p2 = pHead1;
            }
        }
        return p1;
    }

    public static void main(String[] args) {

    }
}