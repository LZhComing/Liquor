package com.liquorcloud.liquor.offer.no0to10;

/**
 * 剑指offer第6题
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class No6 {
    /**
     * 先搞一个内部类，定义树的节点
     */
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
        No6 demo = new No6();
        TreeNode root = demo.reConstructBinaryTree(pre, in);
        preOrderTraverse(root);
        System.out.println();
        inOrderTraverse(root);

    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || in.length <= 0 || pre.length != in.length) {
            throw new RuntimeException("数组不符合规范！");
        }
        return construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }


    private static void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    private static void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left);
        System.out.print(node.val);
        inOrderTraverse(node.right);
    }



    /**
     * 由前序遍历和中序遍历的到根节点
     * @param pre 前序遍历的数组
     * @param in  中序遍历的数组
     * @param pstart 前序遍历开始位置
     * @param pend   前序遍历的结束为止
     * @param istart 中序遍历的开始位置
     * @param iend   中序遍历的结束位置
     */
    public TreeNode construct(int[] pre, int[] in, int pstart, int pend, int istart, int iend){

        //前序遍历的第一个数字为根节点
        TreeNode root = new TreeNode(pre[pstart]);
        if(pstart>pend || istart>iend){
            return null;
        }
        /*//记录中序遍历中根节点的位置
        int index = istart;

        while (index<=iend && in[index]!=root.val){
            index++;
        }

        int leftLen = index-istart;
        int rightLen = iend-index;
        if(leftLen>0){
            root.left = construct(pre,in,pstart+1, pstart+leftLen, istart, index - 1);
        }
        if(rightLen>0){
            root.right = construct(pre, in, pstart + leftLen + 1, pend, index + 1, iend);
        }
        return root;*/
        for(int i=istart;i<iend;i++){
            if(in[i]==pre[pstart]){
                //pstart+i-istart看不懂，估计是数学问题
                root.left = construct(pre,in,pstart+1, pstart+i-istart, istart, i - 1);
                //i-istart+pstart+1看不懂
                root.right = construct(pre, in, i-istart+pstart+1, pend, i + 1, iend);
            }
        }
        return root;
    }


}
