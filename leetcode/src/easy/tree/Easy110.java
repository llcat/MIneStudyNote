package easy.tree;

public class Easy110 {
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

    int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] m = helper(root.left);
        int[] n = helper(root.right);
        int preDelta = Math.max(m[1], n[1]);
//        System.out.println("pre-"+preDelta);
        int delta = 0;
        if (root.left != null || root.right != null) {
            delta = Math.abs(m[0] - n[0]);
        }
//        System.out.println("d-"+delta + "m-" +m[0] + "n-" + n[0]);
        int nextDelta = Math.max(preDelta, delta);
//        System.out.println("nd-"+nextDelta);
        if (m[0] > n[0]) return new int[]{m[0] + 1, nextDelta};
        else return new int[]{n[0] + 1, nextDelta};
    }

    public boolean isBalanced(TreeNode root) {
        int[] r = helper(root);
//        System.out.println(r[0]+"-"+r[1]);
        return r[1] > 1;
    }
}
