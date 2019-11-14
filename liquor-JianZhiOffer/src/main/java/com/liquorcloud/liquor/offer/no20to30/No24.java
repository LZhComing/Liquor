package com.liquorcloud.liquor.offer.no20to30;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 这题讲道理比较简单，就是单纯的二叉树层次遍历，但是我太菜了，不会二叉树的层次遍历，先去学习了一波
 * 借助一个队列。先将二叉树根节点入队，然后开启while循环，将每一个队头的元素出队放到返回序列里面，然后把它的左右子节点入队，当队列空是结束循环
 *
 * 因为需要按层次遍历节点，所以我们可以使用队列先进先出的特点来存储每层节点的值
 * 每取出一个节点就将该节点的左右节点存入队列当中
 *
 * @author zzc
 */
public class No24 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null){return result;}
        //linkedList实现了Quere接口，所以直接用它就好
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size()!=0){
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
            result.add(node.val);
        }
        return result;
    }

}
