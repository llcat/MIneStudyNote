package easy.linkedlist;

import java.util.ArrayList;

/**
 * #234 回文链表
 * 思路: 遍历链表并存入ArrayList, 从前后开始遍历ArrayList判断是否是回文
 * 解析: 这道题实际上是要求最好是O(1)的空间复杂度, 看了题解, 提供了快慢指针的思路:
 * 1. 快慢指针同时遍历, 快指针遍历完成时慢指针位于链表的中间节点
 * 2. 翻转从慢指针开始的后半部分链表
 * 3. 比对翻转的后半部分链表与前半部分链表是否是回文
 * 4. 将之前翻转的后半部分链表复原
 */
public class Easy234 {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            arr.add(p.val);
            p = p.next;
        }
        int start = 0;
        int end = arr.size() - 1;
        while (start < end) {
            int v1 = arr.get(start);
            int v2 = arr.get(end);
            if (v1 != v2) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
