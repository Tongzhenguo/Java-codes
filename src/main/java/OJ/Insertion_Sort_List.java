package OJ;

/**
 * Created by Tongzhenguo on 2017/5/26.
 * Sort a linked list using insertion sort.
 */
public class Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode cur = head; //the node will be inserted
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;

            pre = helper;
            cur = next;
        }

        return helper.next;
    }


}
