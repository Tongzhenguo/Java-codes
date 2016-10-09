package OJ;

/**
 * Created by YYT on 2016/10/9.
 * 给你两个链表表示两个非负数字。
 * 将结果以相反的顺序存储和每个节点包含一个数字。
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *  => 243 + 564 = 807
 *  => (7->0->8)
 */

public class AddTwoNumbers {

    /**
     * 递归，在反转当前节点之前先反转后续节点
     */
    public static ListNode reverse(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode reversedHead = reverse(head.next);
        head.next = head;
        head = null;
        return reversedHead;
    }

    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     *
     */
    public static ListNode reverse2(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        while (null != cur) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //将原链表的头节点的下一个节点置为null，再将反转后的头节点赋给head
        head.next = null;
        head = pre;

        return head;
    }


    /**
     *折腾了一上午，终于把题干和反转单链表搞通了
     * 下面把我的想法描述下，希望可以通过。
     * 先遍历两个链表将其反转
     * 再遍历一次反转后的两个链表
     * 每移动一次，都向结果链表中插入一个数字
     * 时间复杂度应该是O(n)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode p = l1;
            ListNode q = l1.next;//始终指向头节点
            ListNode next1;
            ListNode m = l2;
            ListNode n = l2.next;//始终指向头节点
            ListNode next2;
            //假定两个链表的元素一样多

        while (q != null && n !=null) {
                next1 = q.next;
                next2 = n.next;
                q.next = p;
                n.next = m;
                //move
                p = q;
                m = n;
                q = next1;
                n = next2;
            }
        //将原链表的头节点的下一个节点置为null，再将反转后的头节点赋给head
        l1.next = null;
        l1 = p;
        l2.next = null;
        l2 = m;

        int result = 0;
            int r = 0;//r 是进位
            ListNode l3 = new ListNode(0);
            ListNode k = l3;
            while(q!=null && n!=null){
                result = (q.val + n.val+r);
                int v = result % 10;
                k.next = new ListNode(v);
                //move
                q = q.next;
                n = n.next;
                k = k.next;
                if(result>=10){
                    r = 1;
                }
            }
            return l3.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n121 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(6);
        ListNode n341 = new ListNode(4);

        n1.next = n2;
        n2.next = n121;
        n121.next = null;
        n3.next = n4;
        n4.next = n341;
        n341.next = null;
        /*ListNode reverse = new AddTwoNumbers().reverse2(n1);
        while(reverse!=null){
            System.out.println(reverse.val);
            reverse = reverse.next;
        }*/
        ListNode node = new AddTwoNumbers().addTwoNumbers(n1, n3);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
