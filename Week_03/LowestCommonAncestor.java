/*
 * File Name:LowestCommonAncestor is created on 2020/8/30 7:41 下午 by lite
 *
 * Copyright (c) 2020, xiaoyujiaoyu technology All Rights Reserved.
 *
 */

/**
 * @author lite
 * @Description: p在root的左右子树中 || p == root => root是p的祖先
 * root 是p,q的公共祖先,且root.left,root.right都不是p,q的公共祖先,root是p,q的最近公共祖先
 * => root,p,q仅有三种情况
 * 1.p,q分列在root的左右子树中
 * 2.p==root,q在root的左|右子树中
 * 3.q==root,p在root的左|右子树中
 * dfs
 * @date: 2020/8/30 7:41 下午
 * @since JDK 1.8
 */
public class LowestCommonAncestor {
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || root == p || root == q) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (null == left) {
            return right;
        }
        if (null == right) {
            return left;
        }
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
