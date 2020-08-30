/*
 * File Name:BuildTree is created on 2020/8/30 6:22 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

/**
 * @author lite
 * @Description: 先序遍历,下标0处是根节点;中序遍历,根 左边是左子树 右边是右子树
 * @date: 2020/8/30 6:22 下午
 * @since JDK 1.8
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuild(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode doBuild(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart == preEnd) {
            return null;
        }
        // 前序遍历根节点为 index=0
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 找到中序遍历中根的位置
        int inRootIndex = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (rootVal == inorder[i]) {
                inRootIndex = i;
                break;
            }
        }
        // 左子树个数
        int leftNum = inRootIndex - inStart;
        // 分别构造左右子树
        root.left = doBuild(preorder, preStart + 1, preStart + leftNum + 1, inorder, inStart, inRootIndex);
        root.right = doBuild(preorder, preStart + leftNum + 1, preEnd, inorder, inRootIndex + 1, inEnd);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
