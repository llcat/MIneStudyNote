package easy.linkedlist;

/**
 * #237 删除链表中的节点
 * 思路: 由于只给了要删除的节点, 所以我们不能通过改变头一个节点的next节点从而删除该节点
 * 换一种思路: 将后一个节点的值复制到当前节点, 并删除后一个节点即可。
 */
public class Easy237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
