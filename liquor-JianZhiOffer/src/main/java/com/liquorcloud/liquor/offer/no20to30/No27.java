package com.liquorcloud.liquor.offer.no20to30;


/**
 * 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 这题我一开始想的是，总共分成两步，第一步遍历链表，然后根据每一个节点的next   new出一个新的节点，然后组成一个新的链表
 * 第二步，再次遍历链表，根据每一个节点的random   new 出一个新的节点，设置完指针之后就返回
 * 后来发现，第二步如果还是New节点的话，光说链表中节点的数量就不对，整整成了两倍，菜是原罪
 * 后来想到了最普通的套路，第二次遍历链表时，根据每一个random，从原链表的头结点开始，
 * 一个一个查找这个random指向的节点，找到之后再把当前节点的random指针指向那个节点，如此这般的时间复杂度是  O(n2)
 *
 * 第二种方法是：在第一遍遍历时，使用一个hash表，存储每个节点的random指针指向的节点，这样用O(n)的空间复杂度，换得O(n)的时间复杂度
 *
 *
 * 第一步：先当做简单链表进行复制，遍历链表，
 *
 *
 * @author zzc
 */
public class No27 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead==null){return null;}

        RandomListNode cloneNode = new RandomListNode(pHead.label);
        RandomListNode pNode = pHead;
        while (pNode!=null){
            cloneNode.next = new RandomListNode(pNode.next.label);
            pNode = pNode.next;
            cloneNode = cloneNode.next;
        }

        while (pNode!=null){
            
        }

        return null;
    }


    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}


