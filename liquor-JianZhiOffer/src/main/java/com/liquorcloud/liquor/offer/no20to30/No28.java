package com.liquorcloud.liquor.offer.no20to30;


/** 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *  看到题目首先想到复习一波二叉搜索树，二叉搜索树是一种对于每一个子树，它的左子节点均小于根节点，右子节点均大于根节点
 *  不允许创建新的节点，想到应该是用left rifht两个指针作为前驱指针和后继指针
 *
 *  猜测肯定要用到递归和二叉树的遍历，而且结合二叉搜索树的特点，应该是中序遍历,先处理左子树，然后把根节点放最后，再处理右子树
 *
 *
 *
 *
 *
 * @author zzc on 19.11.29
 */
public class No28 {


    public TreeNode convert(TreeNode head) {
        if(head==null) {
            return head;
        }
        TreeNode lastNodeInList=null;
        lastNodeInList=convertHelper(head,lastNodeInList);
        TreeNode firstNodeInList=lastNodeInList;
        while(firstNodeInList.left!=null) {
            firstNodeInList=firstNodeInList.left;
        }
        return firstNodeInList;
    }

    /**
     * 将以node为根结点的树转化为排序链表，链表头部与lastNode链接，并返回最后一个结点
     */
    private TreeNode convertHelper(TreeNode node,TreeNode lastNode) {
        //处理左子树，获得最大结点
        if(node.left!=null) {
            lastNode=convertHelper(node.left, lastNode);
        }
        //链接最大结点和根结点
        node.left=lastNode;
        if(lastNode!=null) {
            lastNode.right=node;
        }
        //处理右子树
        lastNode=node;
        if(node.right!=null) {
            lastNode=convertHelper(node.right, lastNode);
        }
        return lastNode;
    }
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
