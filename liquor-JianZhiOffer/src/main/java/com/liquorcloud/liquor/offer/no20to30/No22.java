package com.liquorcloud.liquor.offer.no20to30;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 这道题我一开始以为可以用一个成员变量存储min，后来发现问题
 * 因为不知道pop出的是不是最小值，如果不是还好，如果pop出的是min，那么就需要更新这个成员变量，但是我们不知道栈中的哪个数据是倒数第二小的，故不可行
 * 后来又想用一个辅助栈，在push时，作比较，如果push的值比辅助栈的值小就更新辅助栈的值，但是辅助栈只存储一个值的话，还是存在更新的问题，故也不可行
 * 可行的方案是用辅助栈，保证辅助栈和数据栈有相同的元素，但是辅助栈的栈顶始终是最小的那个数，
 * @author zzc
 */
public class No22 {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min  = new Stack<>();

    public void push(int node) {
        data.push(node);
        if(min.isEmpty() || min.peek()>node){
            min.push(node);
        }else{
            //始终保持栈顶元素是那个最小值
            min.push(min.peek());
        }

    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
