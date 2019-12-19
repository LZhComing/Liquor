package com.liquorcloud.liquor.offer.no21to30;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 看到这个题目第一感觉这是啥玩意，但是不能就此放弃
 * 仔细分析题目，找到两个要点，分别为：“二叉搜索树”、“后序遍历”
 * 从而可以确定两个特性，1：输入数组的最后一个数字为二叉树的根、2：如果去掉最后一个数字，剩下的数字可以分为left/right两部分，且left全部比right小
 * 且left和right都是符合规律的后序遍历顺序
 * 因此，要用递归地判断，如果不满足，返回false
 * @author zzc
 */
public class No25 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0){
            return false;
        }
        return checkTree(sequence,0,sequence.length-1);
    }

    private boolean checkTree(int[] sequence,int start,int end){
        if(start>=end){
            //开始和结束重合，说明遍历完了
            return true;
        }
        int i = 0;
        for (;i<end-1;i++){
            //找到左子树和右字数的分界线
            if(sequence[i]>sequence[end]){
                break;
            }
        }
        for(;i<end-1;i++){
            //判断右子树是否都满足规则
            if(sequence[i]<sequence[end]){
                return false;
            }
        }

        boolean left = true;
        //当左子树不为空时
        if (i>start){
            left = checkTree(sequence,start,i-1);
        }
        boolean right = true;
        //当右子树不为空时
        if (i<end){
            right = checkTree(sequence,i,end-1);
        }


        return left && right;
    }


}
