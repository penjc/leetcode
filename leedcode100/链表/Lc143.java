package leedcode100.链表;

/**
 * 143. 重排链表
 * 题目描述：
 *      给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 *      将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *      你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 解题思路：
 *      1. 找到链表的中点
 *      2. 将链表的后半部分反转
 *      3. 将链表的前半部分和反转后的后半部分合并
 */
public class Lc143 {

    public void reorderList(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode head2 = reverseList(mid);
        while (head2.next != null) {
            ListNode nxt = head.next;
            ListNode nxt2 = head2.next;
            head.next = head2;
            head2.next = nxt;
            head = nxt;
            head2 = nxt2;
        }
    }

    // 876. 链表的中间结点
    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 206. 反转链表
    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
