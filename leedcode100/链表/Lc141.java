package leedcode100.链表;

/**
 * 题目描述：
 *     给定一个链表，判断链表中是否有环。
 * 解题思路：
 *      使用双指针，一个指针每次走一步，一个指针每次走两步，如果有环，两个指针会相遇。
 */
public class Lc141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // 慢指针走一步
            fast = fast.next.next;  // 快指针走两步

            if (slow == fast) {     // 相遇，说明有环
                return true;
            }
        }

        return false; // 遇到 null，说明无环
    }
}
