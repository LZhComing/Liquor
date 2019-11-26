package com.liquorcloud.liquor.offer.no0to10;

public class No7 {
    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 分析：题目让找的是中序遍历的下一个节点，但是没有说给定的节点的位置，有以下几种情况
     * 1.给定的节点是有右子树，也就是给定的是一个父节点，那么中序遍历的下一个节点是当前节点的右子树最左侧的那个节点
     * 2.给定的节点无右子树，那么又可以分为两种情况
     *  ①给定节点是其父节点的左子节点，那么中序遍历下一个节点为其父节点
     *  ②给定节点是其父节点的右子节点，那么需要向上遍历父节点的父节点，直到找到一个节点a,a是他的父节点的左子节点，那么a就是要找的节点,其实就是情况①
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode){

        if(pNode == null){
            System.out.println("传入的二叉树为空");
            return null;
        }
        //第一种情况
        if(pNode.right!=null){
            pNode = pNode.right;
            while (pNode.left!=null){
                pNode = pNode.left;

            }
            return pNode;
        }

        //第二种的第一个情况
       while (pNode.next!=null){
           if(pNode.next.left == pNode){
               return pNode.next;
           }
          pNode = pNode.next;
       }
       return null;
    }
}
