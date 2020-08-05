package easy.tree;

public class Easy572 {

    boolean r = false;
    boolean isSameTree(TreeNode s, TreeNode t) {
        return (s == null && t == null) || (s!=null && t!=null && s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        r = r || isSameTree(s, t);
        if (s.left != null) r = r || isSubtree(s.left, t);
        if (s.right != null) r = r || isSubtree(s.right, t);
        return r;
    }
}
