package me.datoucai.structure.tree;

import me.datoucai.base.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> integers = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode now = root;
        while (now != null || !stack.isEmpty()) {
            if (now != null) {
                stack.push(now);
                now = now.left;
            } else {
                now = stack.pop();
                integers.addLast(now.val);
                now = now.right;
            }
        }
        return integers;
    }
}
