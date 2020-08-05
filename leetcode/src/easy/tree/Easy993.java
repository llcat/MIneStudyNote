package easy.tree;

/**
 * #993 二叉树堂兄弟节点
 * 堂兄弟节点, 指深度相同且父节点不同的节点
 * 思路: 遍历二叉树, 记录下两个等于给定值的节点的深度和父节点值即可做判断
 */
public class Easy993 {
    static class Record {
        int parent;
        int depth;
        Record(int parent, int depth) {
            this.parent = parent;
            this.depth = depth;
        }
    }
    Record r1;
    Record r2;
    void travel(TreeNode root, TreeNode pre, int depth, int x, int y) {
        if (root == null) return;
        if (x == root.val && pre != null) {
            r1 = new Record(pre.val, depth);
        }
        if (y == root.val && pre != null) {
            r2 = new Record(pre.val, depth);
        }
        travel(root.left, root, depth + 1, x, y);
        travel(root.right, root, depth + 1, x, y);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        travel(root, null, 0, x, y);
        return r1 != null && r2 != null && r1.parent != r2.parent && r1.depth == r2.depth;
    }
}
