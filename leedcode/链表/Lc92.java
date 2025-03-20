package leedcode.链表;

/**
 * 92. 反转链表 II
 * 题目描述：
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 解题思路：
 *
 */
public class Lc92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        // 创建虚拟头节点，方便处理边界情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;

        for (int i = 1; i < left; i++) {
            p = p.next;
        }
        ListNode prev = null;
        ListNode curr = p.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        p.next.next = curr;
        p.next = prev;
        return dummy.next;

    }
}
