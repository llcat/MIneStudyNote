package easy.tree;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 */

public class Easy617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 ==null && t2 ==null) {
            return null;
        }
        int v1 = t1 !=null ? t1.val : 0;
        int v2 = t2 !=null ? t2.val : 0;
        int v = v1 + v2;
        TreeNode temp = new TreeNode(v);

        if (t1 == null) {
            temp.left = mergeTrees(null, t2.left);
            temp.right = mergeTrees(null, t2.right);
        } else if (t2 == null) {
            temp.left = mergeTrees(t1.left, null);
            temp.right = mergeTrees(t1.right, null);
        } else {
            temp.left = mergeTrees(t1.left, t2.left);
            temp.right = mergeTrees(t1.right, t2.right);
        }
        return temp;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.right = n3;
        n2.right = n4;
        TreeNode r = new Easy617().mergeTrees(n1, n2);
    }
}
