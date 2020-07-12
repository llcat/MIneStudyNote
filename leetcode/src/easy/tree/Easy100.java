package easy.tree;

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 */
public class Easy100 {

    class TreeNode {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        boolean c1 = p == null;
        boolean c2 = p != null && q == null;
        boolean c3 = p != null && q != null && p.val != q.val;
        return !c1 && !c2 && !c3 && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
