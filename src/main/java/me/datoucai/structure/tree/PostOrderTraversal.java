package me.datoucai.structure.tree;

import me.datoucai.base.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> integers = new LinkedList<>();
        Stack stack = new Stack<TreeNode>();
        TreeNode now = root;

        stack.push(now);
        while (!stack.isEmpty()) {
            TreeNode pop = (TreeNode) stack.pop();
            integers.addFirst(pop.val);

            if (pop.left != null) stack.push(pop.left);
            if (pop.right != null) stack.push(pop.right);

        }
        return integers;
    }

}
