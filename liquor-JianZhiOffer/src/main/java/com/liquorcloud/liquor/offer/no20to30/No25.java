package com.liquorcloud.liquor.offer.no20to30;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 *
 *
 *
 * @author zzc
 */
public class No25 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>>  result = new ArrayList<>();

        if(root==null){return result;}

        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        target -= root.val;
        if (target==0 && root.left==null && root.right==null){
            result.add(list);
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);

        return result;

    }
}
