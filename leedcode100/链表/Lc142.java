package leedcode100.链表;

/**
 * 题目描述：
 *      给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 解题思路：
 *      1. 使用快慢指针检测环
 *      2. 重置 ptr 指针，从 head 出发，与 slow 同步移动，直到相遇，即为环的起始点。
 */
public class Lc142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;

        // 1. 使用快慢指针检测环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {  // 相遇，说明有环
                break;
            }
        }

        // 无环，返回 null
        if (fast == null || fast.next == null) {
            return null;
        }

        // 2. 重新寻找环入口
        ListNode ptr = head;
        while (ptr != slow) {
            ptr = ptr.next;
            slow = slow.next;
        }

        return ptr; // 环的起始点
    }
}
