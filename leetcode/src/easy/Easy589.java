package easy;
import java.util.*;

// Definition for a Node.
class Node {
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

public class Easy589 {
    public List<Integer> preorder(Node root) {
        List<Integer> r = new ArrayList<>();
        if (root == null) return r;
        r.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                r.addAll(preorder(node));
            }
        }
        return r;
    }

    /**
     * 迭代遍历的情况下，我们需要找一个位置将我们暂时遍历不到的节点
     * 存起来，在递归时，这些值是存在函数栈里面的，这里我们也用一个栈来保存当前还没访问到的节点。
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> r = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) return r;
        Node nextRoot = root;
        while (nextRoot != null) {
            r.add(nextRoot.val);
            if (nextRoot.children != null) {
                for (int i = nextRoot.children.size()-1; i>=0; i--) {
                    stack.push(nextRoot.children.get(i));
                }
            }
            if (!stack.isEmpty()) {
                nextRoot = stack.pop();
            } else {
                nextRoot = null;
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
        List<Integer> r = new Easy589().preorder1(root);
    }
}
