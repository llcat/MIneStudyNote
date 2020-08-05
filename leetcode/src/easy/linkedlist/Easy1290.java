package easy.linkedlist;

/**
 * #1290 二进制链表转整数
 * 思路: 遍历链表, 二进制转十进制即可。
 * 值得一提的: 我用的java提供的Integer.parseInt(String s, 10),
 * 实际上知道某个进制的高位到低位的序列是可以直接求解的, 如下：
 * r = 0; r = r * 进制数(2, 8, 10, 16...) + 当前位值
 */
public class Easy1290 {
    public int getDecimalValue(ListNode head) {
        ListNode p = head;
        int r = 0;
        while (p != null) {
            r = r * 2 + p.val;
            p = p.next;
        }
        return r;
    }
}
