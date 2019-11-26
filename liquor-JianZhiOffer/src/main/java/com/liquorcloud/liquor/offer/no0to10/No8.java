package com.liquorcloud.liquor.offer.no0to10;

import java.util.Stack;

public class No8 {
    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 思路：在插入元素时，随便往stack1插入，例如插入一个数据a，那么stack1是[a],stack2是空，再插入数据 b,c,d到stack1,
     * 那么stack1从栈顶到栈底依次是[d,c,b,a]，按照队列先进先出的原则，第一个删除的应该是a，但是现在stack1栈顶的元素是d,可以利用第二个栈
     * 依次把stack1中的数据弹出，然后放到stack2中，然后删除stack2的栈顶元素，就实现了删除队列的第一个元素
     * 至于插入操作，直接push到stack1即可。
     */


    public void push(int node) {
            stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            if(stack1.empty()){
                System.out.println("stack1为空");
                throw new RuntimeException("队列为空！");
            }else{
                while (!stack1.empty()){
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }
}
