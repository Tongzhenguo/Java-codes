package OJ.lineartable;


import datastructure.RandomListNode;

/**
 * Created by tongzhenguo on 2019/10/9.
 */


public class JZOfferRandLinkedListDeepCopy {

    // 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
    // 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
    public RandomListNode Clone(RandomListNode pHead){
        // 时间复杂度O(n),空间复杂度O(1)
        if(pHead == null){
            return null;
        }
        // 1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        // 2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        // 3、拆分链表，将链表拆分为原链表和复制后的链表
        RandomListNode nHead = null;
        RandomListNode p = pHead;
        // //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (p!=null){
            RandomListNode tmp = p.next;
            p.next = new RandomListNode(p.label);
            p.next.next = tmp;
            p = tmp;
        }
        p = pHead;
        // a,a1,b,b1,c,c1
        while (p!=null){
            // 新结点A1的random指向对应原结点A的random(比如C)的下一个，即新结点(即C1)
            p.next.random = p.random!=null?p.random.next:null;
            p = p.next.next;
        }
        // 3、拆分链表，将链表拆分为原链表和复制后的链表
        nHead = pHead.next;
        p = pHead;
        while (p != null){
            RandomListNode cloneNode = p.next;
            p.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            p = p.next;
        }
        return nHead;
    }

    public static void main(String[] args) {
        // {1,2,3,4,5,3,5,#,2,#}
        RandomListNode a1 = new RandomListNode(1);
        RandomListNode a2 = new RandomListNode(2);
        RandomListNode a3 = new RandomListNode(3);
        RandomListNode a4 = new RandomListNode(4);
        RandomListNode a5 = new RandomListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a1.random = a3;
        a2.random = a5;
        a3.random = null;
        a4.random = a2;
        a5.random = null;

        RandomListNode clone = new JZOfferRandLinkedListDeepCopy().Clone(a1);
        while (clone != null){
            System.out.println(clone.label);
            clone = clone.next;
        }

    }

}
