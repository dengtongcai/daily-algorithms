package me.datoucai.structure.tree;

import me.datoucai.base.TreeNode;

public class ReverseTree {
    public static TreeNode reverse(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = reverse(root.right);
            root.right = reverse(root.left);
        }
        return root;
    }
}
