package leedcode.链表;

/**
 * 题目描述：
 *      判断一个链表是否为回文链表。
 * 解题思路：
 *      1. 快慢指针找到链表中点
 *      2. 反转后半部分链表
 *      3. 比较前后两部分链表
 */
public class Lc234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // Step 1: 快慢指针找到链表中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: 反转后半部分链表
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Step 3: 比较前后两部分链表
        ListNode p1 = head, p2 = prev;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
}
