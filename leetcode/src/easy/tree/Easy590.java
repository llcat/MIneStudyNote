package easy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Easy590 {
    public List<Integer> postorder(Node root) {
        List<Integer> r = new ArrayList<>();
        if (root == null) return r;
        if (root.children != null) {
            for (Node node : root.children) {
                if (node.children != null) {
                    r.addAll(postorder(node));
                } else {
                    r.add(node.val);
                }
            }
            r.add(root.val);
        }
        return r;
    }
    public List<Integer> postorder1(Node root) {
        List<Integer> r = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node nextRoot = root;
        while (nextRoot != null) {
            if (nextRoot.children != null) {
                stack.push(new Node(nextRoot.val));
                for (int i = nextRoot.children.size()-1; i>=0; i--) {
                    stack.push(nextRoot.children.get(i));
                }
            } else {
                r.add(nextRoot.val);
            }
            if (!stack.isEmpty()) {
                nextRoot = stack.pop();
            } else {
                nextRoot = null;
            }
        }
        return r;
    }

    /**
     * 别人的solution, 这个写法很简单明了, 很棒
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        List<Integer> r = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node == null) continue;
            r.add(0, node.val);
            for(Node n : node.children) {
                stack.push(n);
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
        List<Integer> r = new Easy590().postorder1(root);
    }
}
