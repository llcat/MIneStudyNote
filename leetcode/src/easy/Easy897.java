package easy;
import java.util.ArrayList;
import java.util.List;

public class Easy897 {
    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = traversal(root);
        TreeNode r = null;
        TreeNode temp = null;
        for (int val : list) {
            if (temp == null) {
                temp = new TreeNode(val);
                r = temp;
            } else {
                temp.right = new TreeNode(val);
                temp = temp.right;
            }
        }
        return r;
    }

    private List<Integer> traversal(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        if (root == null) return r;
        if (root.left !=null) {
            r.addAll(traversal(root.left));
        }
        r.add(root.val);
        if (root.right != null) {
            r.addAll(traversal(root.right));
        }
        return r;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n1, n3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        TreeNode n6 = new TreeNode(6, n5, n7);
        TreeNode root = new TreeNode(4, n2, n6);
        TreeNode r = new Easy897().increasingBST(root);
    }
}
