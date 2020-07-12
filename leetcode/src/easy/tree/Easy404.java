package easy.tree;

public class Easy404 {

    int r = 0;
    void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                this.r += root.left.val;
            }
            helper(root.left);
        }
        if (root.right != null) {
            helper(root.right);
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return this.r;
    }
}
