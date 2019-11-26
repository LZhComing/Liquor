package com.liquorcloud.liquor.offer.no0to10;

/**
 * @author lenovo
 */
public class No9 {

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     */

    public static void main(String[] args) {
        int n = 39;
        System.out.println(getNum(n));
        System.out.println(getnum(n));
    }

    /**
     * 递归的版本
     * @param n
     * @return
     */
    public static int getnum(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return getnum(n-1)+getnum(n-2);
    }

    /**
     * 循环的方法
     * 思路：递归会造成很多次重复的计算，时间复杂度是O(n的指数)，
     * 这里把每一次计算的值保存下来，从下面一层一层地向上算，随后得到第n代的数，时间复杂度O(n)
     */
    static int getNum(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        //这仨值是temp是当前的那一代，n_1和n_2分别是前面那俩代的数字
        int n_2 = 0;
        int n_1 = 1;
        int temp = 1;

        for(int i=2;i<=n;i++){
            temp = n_1+n_2;
            n_2 = n_1;
            n_1 = temp;
        }
        return temp;
    }
}
