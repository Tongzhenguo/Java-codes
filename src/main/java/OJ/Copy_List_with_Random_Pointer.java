package OJ;

import datastructure.RandomListNode;

/**
 * Created by Tongzhenguo on 2017/5/9.
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 一个链表，其每一个元素都有一个随机指针(可能指向链表任意结点或者置空)
 * 实现链表的深度复制
 */
public class Copy_List_with_Random_Pointer {
    /**
     The algorithm is composed of the follow three steps which are also 3 iteration rounds.
     Iterate the original list and duplicate each node. The duplicate
     of each node follows its original immediately.
     Iterate the new list and assign the random pointer for each
     duplicated node.
     Restore the original list and extract the duplicated nodes.
     */

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head;
        RandomListNode next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {

            next = iter.next;
            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;

            copy.next = next;
            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy;
        RandomListNode copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;
            iter = next;
        }

        return pseudoHead.next;

    }


}
