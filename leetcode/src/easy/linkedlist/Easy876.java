package easy.linkedlist;

/**
 * #876 链表的中间节点
 * 思路: 快慢双指针
 */
public class Easy876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
