package OJ.lineartable;


import datastructure.ListNode;

/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferLinkedListEntryNodeOfLoop {
    // 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
    public ListNode EntryNodeOfLoop(ListNode pHead) {
//        链接：https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4?f=discussion
//        来源：牛客网

        // note(却顾所来径):设置快慢指针，假如有环，他们最后一定相遇。
        ListNode fast=pHead;
        ListNode low=pHead;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(fast==low)
                break;
        }
        if(fast==null||fast.next==null)
            return null;
        // 两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。
        low=pHead;
        while(fast!=low){
            fast=fast.next;
            low=low.next;
        }
        return low;
    }


    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a3;
        System.out.println(new JZOfferLinkedListEntryNodeOfLoop().EntryNodeOfLoop(a1).val);
    }

}
