package easy.tree;

import java.util.Stack;

/**
 * 965. Univalued Binary Tree
 * https://leetcode.com/problems/univalued-binary-tree/
 */
public class Easy965 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
            if (pre != null && pre.val != n.val) {
                return false;
            }
            pre = n;
        }
        return true;
    }
}
