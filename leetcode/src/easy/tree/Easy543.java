package easy.tree;

public class Easy543 {
    int maxDiameter;
    int dfs(TreeNode root) {
        if (root == null) return 0;
        int L, R;
        L = dfs(root.left);
        R = dfs(root.right);
        if (L + R > maxDiameter) {
            maxDiameter = L + R;
        }
        return Math.max(L, R) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        dfs(root);
        return maxDiameter;
    }
}
