package leedcode.链表;

/**
 * 题目描述：
 *      题目要求对链表进行排序，并返回排序后的链表头节点。
 * 解题思路：
 * 归并排序（Merge Sort）
 *      使用快慢指针找到链表的中点
 *          通过 快慢指针（快指针 fast 每次移动两步，慢指针 slow 每次移动一步），找到链表的中间位置，将链表拆分为两部分。
 *      递归地对左右部分排序
 *          递归地调用 sortList 处理左右两个子链表。
 *      合并两个已排序的链表
 *          使用 归并排序 的合并方法（类似于 mergeTwoLists），合并两个有序链表。
 * 时间复杂度分析
 *      找到中点：O(n)
 *      归并排序递归分割：O(log n) 层递归
 *      合并两个子链表：O(n)
 *      总体时间复杂度：O(n log n)
 */
public class Lc148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 1. 找到中间节点，拆分链表
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null; // 断开链表，分成左右两个部分

        // 2. 递归排序左右两部分
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 3. 归并两个有序链表
        return merge(left, right);
    }

    // 快慢指针找到链表的中点
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next; // fast 先走一步，保证 slow 是中间靠左的节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // 返回中点
    }

    // 合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2; // 连接剩余部分
        return dummy.next;
    }
}

