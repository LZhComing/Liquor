package com.liquorcloud.liquor.offer.no1to10;

public class No2 {
    /**
     * 在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字是重复的。
     * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
     * 例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字2或者3。
     */
    public static void main(String[] args) {
        int[] arr = {1,5,3,4,2,6,2,3};
        System.out.println("找到了"+find2(arr));
    }

    /**
     * 简单粗暴的方法，新建一个辅助数组，然后一个一个复制到辅助数组索引位置
     */
    private static int find(int[] arr){
        //省略了输入参数检查
        int[] arr2 = new int[arr.length];
        for (int value : arr) {
            if (arr2[value] == value) {
                return value;
            }
            arr2[value] = value;
        }
        return -1;
    }

    /**
     * 减小空间复杂度的算法，
     * 因为n个数字都在1-n之间，至少有一个数字重复
     * 只需要从中间分割开，统计两端数字的个数，类似于二分查找？
     */
    private static int find2(int[] arr){
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

        int low = 1;
        int high = arr.length-1;
        while (low<=high) {
            //先算出来中间的索引值
            int m = (low + high) / 2;
            //统计左边的数字个数
            int count = getCount(arr,low,m);
            //低位和高位重合，说明要找到数了，
            if(low==high){
                if(count>1){
                    return low;
                }else{
                    break;
                }
            }
            if(count > m-low+1){
                high = m;
            }else{
                low = m+1;
            }
        }
        return -1;
    }

    /**
     * 获得从low到high之间的数字个数
     */
    private static int getCount(int[] arr, int low, int high) {
        if(arr.length==0){
            return 0;
        }
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=low && arr[i]<=high){
                count++;
            }
        }
        return count;
    }
}
