package leedcode100.链表;

/**
 * 876. 链表的中间结点
 * 题目描述：
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 */
public class Lc876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            // 快指针一次走两步，慢指针一次走一步
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
