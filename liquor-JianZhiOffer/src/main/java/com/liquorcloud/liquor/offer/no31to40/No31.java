package com.liquorcloud.liquor.offer.no31to40;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 这个题属于效率题，猛一看可以通过遍历暴力破解，但这肯定不是我想要的
 * 第一直觉感觉可以先排序，再按下标取就完事了，用快速排序
 * 剑指offer上的方法是使用一个大顶堆，我对堆调整不太熟悉，后面再看吧
 *
 * @author zzc on 19.12.19
 */
public class No31 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length<k || k<=0){
            return list;
        }

        quickSort(input,0,input.length-1);
        for (int i=0;i<k-1;i++){
            list.add(input[i]);
        }
        return list;
    }

    public static void quickSort(int[] arr,int start,int end){
        if (start<end){
            int index = arr[start];
            int left = start;
            int right = end;

            while (left<right){
                while (left<right && index<=arr[right]){
                    right--;
                }
                arr[left] = arr[right];
                while (left<right && index>arr[left]){
                    left++;
                }
                arr[right] = arr[left];
            }
            //当左右重合,此时左右对应的坐标即是中间那个数字
            arr[left] = index;
            quickSort(arr,start,left-1);
            quickSort(arr,left+1,end);
        }
    }

    public static void main(String[] args) {
        int array[] = {2, 5, 3, 1, 7, 8, 10};
        System.out.println("排序之前");
        for (int element : array) {
            System.out.print(element + " ");
        }

        quickSort(array, 0, array.length - 1);

        System.out.println("/n排序之后");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }


}
