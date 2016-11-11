package OJ;

/**
<<<<<<< Updated upstream
 * Created by YYT on 2016/10/26.
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 *Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 * 简单的说就是只给你要删除的节点，而不给你链表头；怎么实现单链表的删除
 */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        DeleteNodeInLinkedList o = new DeleteNodeInLinkedList();
        o.deleteNode(three);
        ListNode p = one;
        while (p!=null){
            System.out.println(p.val);
            p = p.next;
        }
    }

}
