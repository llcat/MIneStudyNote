package easy.linkedlist;

/**
 * #203 移除链表元素
 * 思路: 考察链表删除元素, 记得最后要检查头元素是否符合要求
 */
public class Easy203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        // 判断头节点
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }
}
