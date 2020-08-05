package easy.tree;

public class Easy606 {
    StringBuffer s;

    boolean isLeaf(TreeNode t) {
        return t != null && t.left == null && t.right == null;
    }
    void preOrderTravel(TreeNode t) {
        if (t == null) return;
        s.append(t.val);
        if (!isLeaf(t) && t.left == null) {
            s.append("()");
        }
        if (t.left != null) {
            s.append("(");
            preOrderTravel(t.left);
            s.append(")");
        }
        if (!isLeaf(t) && t.right == null) {
            s.append("()");
        }
        if (t.right != null) {
            s.append("(");
            preOrderTravel(t.right);
            s.append(")");
        }
    }

    public String tree2str(TreeNode t) {
        s = new StringBuffer();
        preOrderTravel(t);
        return s.toString();
    }
}
