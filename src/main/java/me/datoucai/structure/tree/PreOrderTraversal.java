package me.datoucai.structure.tree;

import lombok.extern.slf4j.Slf4j;
import me.datoucai.base.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历
 */
@Slf4j
public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> integers = new LinkedList<>();
        Stack stack = new Stack<TreeNode>();
        TreeNode now = root;
        while (now != null || !stack.isEmpty()) {
            if (now != null) {
                integers.addLast(now.val);
                stack.push(now);
                now = now.left;
            } else {
                TreeNode node = (TreeNode) stack.pop();
                now = node.right;
            }
        }
        return integers;
    }
}
