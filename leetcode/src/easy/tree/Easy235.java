package easy.tree;

public class Easy235 {
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

    TreeNode result;
    public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = helper(root.left, p, q);
        boolean rson = helper(root.right, p, q);
        boolean find = (lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson));
        if (find) this.result = root;
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return this.result;
    }
}
