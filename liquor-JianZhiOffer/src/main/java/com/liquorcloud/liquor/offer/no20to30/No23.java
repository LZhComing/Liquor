package com.liquorcloud.liquor.offer.no20to30;


import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 *
 * @author zzc
 */
public class No23 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {

       /* Stack<Integer> stack = new Stack<>();
        //先按入栈顺序入栈
        for (int value : pushA) {
            stack.push(value);
        }
        //再按出栈顺序出栈
        for (int value : popA) {
            if (stack.peek() != value) {
                return false;
            }
            stack.pop();
        }

        return true;*/

       Stack<Integer> stack = new Stack<>();
       if(pushA.length!=popA.length){return false;}
       for (int i=0;i<popA.length;i++){
           while (i<pushA.length){
               if(stack.peek()!=popA[i+1]){
                   return false;
               }

           }
       }
       return true;
    }
}
