package easy;

public class Easy700 {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode r = null;
        if (root.val == val) {
            return root;
        } else if (val < root.val) {
            r = searchBST(root.left, val);
        } else if (val > root.val){
            r = searchBST(root.right, val);
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
        TreeNode r = new Easy700().searchBST(root, 4);
    }
}
