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


    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null){
            return null;
        }
        TreeNode lastNodeInList;
        lastNodeInList = convertHelp(pRootOfTree, null);
        while (lastNodeInList.left!=null){
            lastNodeInList = lastNodeInList.left;
        }
       return lastNodeInList;
    }

    /**
     * 递归修改链表的指针，利用中序遍历的递归实现，
     * @param head 递归处理中的当前节点
     * @param lastNode 已经排序好的链表中的最后一个节点
     * @return 排序后链表的最后一个节点
     */
    private TreeNode convertHelp(TreeNode head, TreeNode lastNode) {
        //先处理左子树
        if (head.left!=null){
            lastNode = convertHelp(head.left,lastNode);
        }
        //修改左子树最大的节点和当前节点的指针
        head.left = lastNode;

        if (lastNode!=null){//需要确保左子树不为空时，采取操作左子树的最大节点，避免空指针异常
            lastNode.right = head;
        }

        //把当前节点设置为最后一个节点
        lastNode = head;
        //再处理右子树
        if (head.right!=null){
            lastNode = convertHelp(head.right,lastNode);
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
