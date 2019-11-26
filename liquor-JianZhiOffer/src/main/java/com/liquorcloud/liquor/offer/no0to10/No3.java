package com.liquorcloud.liquor.offer.no0to10;

public class No3 {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param args
     */
    public static void main(String[] args) {
        int[][] b={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] b2={{1,2},{7,8},{9,10,11,12}};
        System.out.println(find(b2, 0));
    }

    /**
     * 可以从右上角或者左下角，开始查找，
     */
    private static boolean find(int[][] arr,int a){
        int hang = arr.length-1;
        int lie = 0;
        while (lie<arr[0].length-1 && hang>0 ){
            if(a==arr[hang][lie]){
                return true;
            }
            //比左下角的数字小，应该上移
            if(a<arr[hang][lie]){
                hang--;
            }else{
                lie++;
            }
        }
        return false;
    }
}
