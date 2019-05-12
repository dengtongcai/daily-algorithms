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
        stack.push(now);
        while (!stack.isEmpty()) {
            now = (TreeNode) stack.pop();
            integers.addLast(now.val);
            if(now.right!=null){
                stack.push(now.right);
            }
            if(now.left!=null){
                stack.push(now.left);
            }
        }
        return integers;
    }
}
