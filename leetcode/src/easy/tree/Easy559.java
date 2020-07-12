package easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 559. Maximum Depth of N-ary Tree
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */

public class Easy559 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        return calDepth(root, 0);
    }

    public int calDepth(Node root, int depth) {
        int r;
        if (root == null) {
            r = depth;
            return r;
        }
        r = depth + 1;
        if (root.children != null && root.children.size() > 0) {
            int childDepth = 0;
            for (Node node : root.children) {
                int t = calDepth(node, r);
                if (t > childDepth) {
                    childDepth = t;
                }
            }
            if (childDepth > r) {
                r = childDepth;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        List<Node> c = new ArrayList<>();
        List<Node> c1 = new ArrayList<>();
        c1.add(n5);
        c1.add(n6);
        Node n2 = new Node(2, c1);
        c.add(n1);
        c.add(n2);
        c.add(n3);
        c.add(n4);
        Node root = new Node(0, c);
        int r = new Easy559().maxDepth(root);

        System.out.println(r);
    }
}
