package com.liquorcloud.liquor.offer.no1to10;


public class No10 {
    /**
     * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     *      * // 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
     *      * // {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
     */

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,2,3};
        int length = arr.length;
        System.out.println(findMin(arr, length));

    }

    private static int findMin(int[] arr, int length){
        if(length==0){
            return 0;
        }
        //左边的指针
        int p1 = 0;
        //右边的指针
        int p2 = length-1;

        //如果是升序的数组呢
        if(arr[p1] < arr[p2]){
            return arr[p1];
        }
        while(p1<p2-1){
            int m = (p1 + p2)/2;
            if(arr[m]>=arr[p1]){
                p1 = m;
            }
            if(arr[m]<=arr[p2]){
                p2 = m;
            }
        }
        return arr[p2];
    }



}
