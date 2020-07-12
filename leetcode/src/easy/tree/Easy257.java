package easy.tree;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

public class Easy257 {
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

    List<String> r = new ArrayList<>();

    public void helper(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            s = s + root.val;
            r.add(s);
        } else {
            s = s + root.val + "->";
            if (root.left != null) helper(root.left, s);
            if (root.right != null) helper(root.right, s);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return this.r;
        helper(root, "");
        return this.r;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        root.left = n1;
        n1.right = n2;
        List<String> r = new Easy257().binaryTreePaths(root);
    }
}
