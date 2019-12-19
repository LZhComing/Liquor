package com.liquorcloud.liquor.offer.no21to30;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 注意要点
 * 1.result 和 list要定义在递归方法外面，要不然返回的总为零
 * 2.每次经过一个节点，把target减去当前节点的值，当target为0并且当前节点是叶子节点时，说明满足条件，应该把list加进result
 * 3.把list加进result时，需要new一个list,因为直接加的话，加的是对象的引用，后面会根据list的变化而变化，导致返回的结果不对
 * 4.在当前结点完成左右子树的路径搜索后要删除当前节点，目的是为了回退到当前节点的父节点
 *
 *
 * @author zzc
 */
public class No26 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    ArrayList<ArrayList<Integer>>  result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if(root==null){return result;}

        list.add(root.val);
        target -= root.val;
        if (target==0 && root.left==null && root.right==null){
            result.add(new ArrayList<>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);

        return result;

    }
}
