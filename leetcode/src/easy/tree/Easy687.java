package easy.tree;

/**
 * #687 求二叉树的最长同值路径
 * 与#543求二叉树直径思路基本一致, 还是找左右子树深度的问题
 * 不过本题在于找出一条特殊的最长直径, 该直径上各点值均相等,
 * 所以计算左右子树深度时要判断是否与根节点值相等
 */
public class Easy687 {
    int longest;

    int dfs(TreeNode root) {
        if(root == null) return 0;
        int L = dfs(root.left);
        int R = dfs(root.right);
        int ld = 0;
        int rd = 0;
        if (root.left != null && root.left.val == root.val) {
            ld = L + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rd = R + 1;
        }
        longest = Math.max(longest, ld + rd);
        return Math.max(ld, rd);
    }

    public int longestUnivaluePath(TreeNode root) {
        longest = 0;
        dfs(root);
        return longest;
    }
}
