package leedcode.链表;

/**
 * 题目描述：
 *      给定一个链表，删除链表的 倒数第 n 个节点，并返回 修改后的链表头。
 * 解题思路
 *      方法：双指针（快慢指针）
 *          使用快慢指针找到倒数第 n 个节点：
 *          让 快指针 fast 先前进 n 步，然后慢指针 slow 从 head 开始同步前进。
 *          当 fast 走到链表末尾，slow 的下一个节点就是需要删除的节点。
 *      特殊情况处理：
 *          删除头结点（即 n 等于链表长度），可直接返回 head.next。
 *          链表只有一个节点，删除后返回 null。
 * 时间复杂度：O(L)，其中 L 是链表长度，只遍历了一次。
 * 空间复杂度：O(1)，只用了两个额外指针 fast 和 slow。
 */
public class Lc19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); // 伪头节点
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        // 让 fast 先走 n+1 步（为了让 slow 指向删除节点的前一个）
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 让 fast 和 slow 一起移动，直到 fast 到达链表尾部
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除倒数第 n 个节点
        slow.next = slow.next.next;

        return dummy.next; // 返回真正的头结点
    }
}
