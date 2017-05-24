package OJ;

/**
 * Created by Tongzhenguo on 2017/5/24.
 Given a list, rotate the list to the right by k places, where k is non-negative.
 循环右移k次单链表
 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 *
 */
public class Rotate_List {

    /*public ListNode rotateRight(ListNode head, int k) {
        if( head.next==null || head==null){
            return head;
        }
        int i = 0;
        ListNode t = head;//count
        ListNode left = head;//n-k-1
        ListNode right = left;//n-1
        while( t.next!= null ){
            i += 1;
            t = t.next;
            right = right.next;
            if( i>k ){
                left = left.next;
            }
        }
        right.next = head.next;
        head.next = left.next;
        left.next = null;//final node
        return head;
    }*/

    /**
     * Since n may be a large number compared to the length of list.
     * So we need to know the length of linked list.After that, move the list after the (l-n%l )th node to the front to finish the rotation.
     Ex: {1,2,3} k=2 Move the list after the 1st node to the front
     Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the front.
     So the code has three parts.
     Get the length
     Move to the (l-n%l)th node
     3)Do the rotation
     */
    public ListNode rotateRight(ListNode head, int n) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }


}
