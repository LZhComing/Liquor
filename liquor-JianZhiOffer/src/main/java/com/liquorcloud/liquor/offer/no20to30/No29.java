package com.liquorcloud.liquor.offer.no20to30;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列
 * 例如输入字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 *
 *
 * 求字符串的全排列，类似数字的全排列，不同的好像是没办法进行排序
 * 按字典顺序，说明要对返回的list进行排序
 *
 * 思路：可以把字符串转成字符数组之后，看成两个部分，第一部分是人任选的一个字符(通常首先是第一个)，
 * 第二部分是剩下的字符。然后把第一部分和后面的字符挨个互换
 * 换完一波之后，把第一部分的字符放回原来的位置(一定要做)，然后固定他，再把后面剩下的字符做相同的处理，递归进行
 * 直到到了最后一个字符
 *
 * @author zzc on 19.11.30
 */
public class No29 {

    public ArrayList<String> Permutation(String str) {
        ArrayList list = new ArrayList();
        if (str == null || str.length() == 0){
            return list;
        }
        PermutationHelper(str.toCharArray(),0,list);
        Collections.sort(list);
        return list;
    }

    private void PermutationHelper(char[] chars, int index, ArrayList list) {
            if(index==chars.length-1){
                if (!list.contains(String.valueOf(chars))){
                    list.add(String.valueOf(chars));
                }
            }
            for (int i = index;i<chars.length;i++){
                //交换位置
                char temp = chars[index];
                chars[index] = chars[i];
                chars[i] = temp;

                //递归进行下一波
                PermutationHelper(chars,index+1,list);

                //把第一部分的字符放回原来的位置
                chars[i] = chars[index];
                chars[index] = temp;

            }
    }
}
