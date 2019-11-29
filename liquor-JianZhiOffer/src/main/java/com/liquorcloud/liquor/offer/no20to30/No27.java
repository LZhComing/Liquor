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
 * 第一步：先当做简单链表进行复制，遍历链表，注意是在原来的每个节点后面复制一个节点
 * 第二步：从头结点开始，赋值节点的随即指针肯定是原节点的随即指针指向的节点的下一节点
 * 第三步： 拆分链表，根据奇偶位置，偶数位置的肯定是要返回的复制之后的链表节点
 *
 *
 * @author zzc
 */
public class No27 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead==null){return null;}

        RandomListNode pNode = pHead;
        while (pNode!=null){

            RandomListNode cpNode = new RandomListNode(pNode.label);
            //新建一个节点并放在原链表头结点的后面
            cpNode.next = pNode.next;
            pNode.next = cpNode;

            pNode = cpNode.next;
        }

        pNode = pHead;
        while (pNode!=null){
            //必须考虑随机指针为空的情况
            if(pNode.random!=null){
                pNode.next.random = pNode.random.next;
            }
            pNode = pNode.next.next;
        }


        pNode = pHead;
        RandomListNode cloneHead = pHead.next;
        while (pNode!=null){
            RandomListNode cloneNode = pNode.next;
            pNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            pNode = pNode.next;


            //cloneNode.next = cloneNode.next.next;
            //pNode3 = pNode3.next.next;
        }
        return cloneHead;
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


