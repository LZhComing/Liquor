package com.liquorcloud.liquor.offer.no20to30;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 看到这个题，第一下想到的使用一个hash表，先遍历一遍数组，把每个数组出现的次数记录在hash表中，然后再遍历hash表，这样时间复杂度O(n)
 * 但是空间复杂度比较大
 *
 *
 */
public class No30 {

    /**
     * 使用HashMap的方式，能通过牛客，但是估计面试不是最优解
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<>(16);
        int result = 0;
        for (Integer a : array){
            if (map.get(a)==null){
                map.put(a,1);
            }else {
                Integer count = map.get(a);
                map.put(a,count+1);
            }
        }
        for (Integer key : map.keySet()){
            if (map.get(key) > array.length/2){
                result = key;
                return result;
            }
        }
        return result;
    }

}
