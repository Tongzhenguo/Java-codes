package OJ.lineartable;


import datastructure.ListNode;

/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferLinkedListDelDuplication {
    // 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5。
    public ListNode deleteDuplication(ListNode pHead) {
        // 关键信息：排序的链表
        // 只需要判断两个相邻结点是否重复，如果重复就删除

        // NOTE(一步一步往上爬) 1. 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
        // NOTE(一步一步往上爬) 2.设置 pre ，last 指针， pre指针指向当前确定不重复的那个节点，而last指针相当于工作指针，一直往后面搜索。
        if (pHead==null || pHead.next==null){return pHead;}
        ListNode Head = new ListNode(0);
        Head.next = pHead;

        // 保存上次遍历的结点
        ListNode pre = Head;
        ListNode p = Head.next;
        while (p != null){
            if(p.next != null && p.val == p.next.val){
                // note(tzg)：考虑连续重复，都删除；所以应该是while不是if
                while (p.next != null && p.val == p.next.val){
                    p = p.next;
                }
                // 切断所有重复结点
                pre.next = p.next;
                p = p.next;
            }else{
                // 不重复
                pre = pre.next;
                p = p.next;
            }
        }
        return Head.next;
    }


    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(4);
        ListNode a7 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        ListNode head = new JZOfferLinkedListDelDuplication().deleteDuplication(a1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

}
