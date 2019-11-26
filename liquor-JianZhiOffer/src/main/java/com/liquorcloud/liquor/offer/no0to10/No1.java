package com.liquorcloud.liquor.offer.no0to10;

public class No1 {
    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
     * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，那么对应的输出是重复的数字2或者3。
     * @param args
     */
    public static void main(String[] args) {
        int[] arr ={1,5,2,7,4,2,1,3};
        System.out.println("找到了"+find(arr));
    }

    private static int find(int[] arr){
        //空数组
        if(arr.length==0){
            return -1;
        }
        //检查数字范围
        for (int value : arr) {
            if (value < 0 || value > arr.length - 1) {
                return -1;
            }
        }
        for(int i=0;i<arr.length;i++){
            int temp;
            //如果数组下标的数字和下标不符，有两中情况，一种是该交换了，一种是找到了重复的数字
            while (arr[i] != i){
                if(arr[arr[i]]==arr[i]){
                    return arr[i];
                }
                // 交换arr[arr[i]]和arr[i]
                temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        return -1;
    }
}
