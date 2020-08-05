package easy.linkedlist;

/**
 * #160 相交链表
 * 思路: 看了题解的思路写的, 比较好的方法是双指针遍历拼接链表
 * 如链表A: a1 -> a2 -> a3 -> c1 -> c2 -> c3
 * 和链表B: b1 -> b2 -> c1 -> c2 -> c3 相交于c1节点可得
 * A + B: a1 -> a2 -> a3 -> c1 -> c2 -> c3 -> b1 -> b2 -> c1 -> c2 -> c3
 * B + A: b1 -> b2 -> c1 -> c2 -> c3 -> a1 -> a2 -> a3 -> c1 -> c2 -> c3
 * 让双指针同时遍历(A + B) 和 (B + A), 有相交节点时, 指针p1 == p2, 返回p1即可。
 */
public class Easy160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA != null && headB != null) {
            ListNode p1 = headA;
            ListNode p2 = headB;
            int addFlag1 = 0;
            int addFlag2 = 0;
            while (p1 != null && p2 != null) {
                if (p1 == p2) return p1;
                p1 = p1.next;
                p2 = p2.next;
                if (p1 == null && addFlag1 == 0) {
                    addFlag1 = 1;
                    p1 = headB;
                }
                if (p2 == null && addFlag2 == 0) {
                    addFlag2 = 1;
                    p2 = headA;
                }
            }
            return null;
        } else {
            return null;
        }
    }
}
