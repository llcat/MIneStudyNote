package easy.linkedlist;

/**
 * #83 删除排序链表中的重复元素
 * 思路: 指针指向当前节点, 如当前节点与下一节点值相同, 当前节点的下个节点指向下下个节点(删除), 否则, 移动当前指针到下一节点
 */
public class Easy83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && next.val == cur.val) {
                cur.next = next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
