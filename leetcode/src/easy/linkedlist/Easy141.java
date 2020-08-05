package easy.linkedlist;

/**
 * #141 环形链表
 * 思路: 快慢双指针, 快指针一次跳2格, 慢指针跳1格, 有环的话两个指针一定会相遇
 * 解析: 还有一种思路是存节点到HashSet, 遍历链表, 有环一定会在HashSet中存在,
 * 需要额外的外部空间
 */
public class Easy141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
