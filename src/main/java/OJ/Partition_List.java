package OJ;

/**
 * Created by Tongzhenguo on 2017/5/31.
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        if( head==null || head.next==null )
            return null;
        ListNode lessHeader = new ListNode(0);
        ListNode lessCur = null;
        lessHeader.next = lessCur;
        ListNode moreHeader = new ListNode(0);
        ListNode moreCur = null;
        moreCur.next = moreCur;
        ListNode p = head.next;
        while ( p!= null ){
            if( p.val<x ){
                lessCur.next = p;
                lessCur = lessCur.next;
            }else {
                moreCur.next = p;
                moreCur = moreCur.next;
            }
            p = p.next;
        }
        p = lessHeader;
       while ( p.next!=null ){
           p = p.next;
       }
        p.next = moreHeader.next;
        return lessHeader;
    }



}
