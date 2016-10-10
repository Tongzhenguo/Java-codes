package OJ;

/**
 * Created by YYT on 2016/10/9.
 * 给你两个链表表示两个非负数字。
 * 每个节点存储一位数字，从低到高排列。
 * 计算连数字的和
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *  =>  2+5+0=７
 *  ＝> 4+6+0=0
 *  =>  3+4+1=8
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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p = l1;
        ListNode m = l2;
        int result = 0;
        int r = 0;//r 是进位
        ListNode l3 = new ListNode(0);//头指针，数据无意义
        ListNode k = l3;
        while(p!=null || m!=null){
            if(p==null){
                result = 0 + m.val+r;
            }
            else if(m==null){
                result = 0 + p.val+r;
            }
            else {
                result = (p.val + m.val+r);
            }
            int v = result % 10;
            k.next = new ListNode(v);
            //move
            if(p!=null){
                p = p.next;
            }
            if(m!=null){
                m = m.next;
            }
            k = k.next;
            if(result>=10){
                r = 1;
            }else {
                r = 0;
            }
        }
        if (r==1){
            k.next = new ListNode(1);
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
        n4.next = null;
        n341.next = null;
      /*  ListNode reverse = new AddTwoNumbers().reverse(n1);
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
