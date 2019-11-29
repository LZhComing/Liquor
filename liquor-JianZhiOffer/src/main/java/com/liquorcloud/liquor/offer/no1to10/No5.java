package com.liquorcloud.liquor.offer.no1to10;

import java.util.Stack;

public class No5 {
    /**
     * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值
     */
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        ListNode ln7 = new ListNode(7);
        ListNode ln8 = new ListNode(8);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = null;

        printListReversinglyByStack(ln1);
        String s;
    }

    public static void printListReversinglyByStack(ListNode listNode){
        if(listNode == null){ //如果为空，直接返回
            return;
        }
        Stack<Integer> stack = new Stack<Integer>(); //借助于栈
        while(listNode!=null){
            stack.push(listNode.val); //将数据放入栈中
            listNode = listNode.next; //指针域指向下一个指针
        }
        while(!stack.isEmpty()){
            int a = stack.pop();
            System.out.print(a + " "); //借助于栈输出
        }
    }


    //自定义的链表内部类
    static class ListNode{
        int val;
        //指向下一个节点的指针
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }


    }

}
