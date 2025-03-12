package leedcode100.链表;

/**
 * 题目描述：
 *      给定两个 非空 的链表 l1 和 l2，它们表示两个非负整数。数字以 逆序 方式存储，每个节点只能存储 一位 数字。请你将这两个数相加，并以相同的链表形式返回和。
 * 解题思路：
 *      模拟加法过程：
 *      从 l1 和 l2 的最低位（即链表头部）开始相加。
 *      维护一个 carry 变量表示进位，初始为 0。
 *      遍历 l1 和 l2，每次相加两个节点的值，加上进位，然后取模 10 作为当前位的值，商 carry 作为进位。
 *      当 l1 或 l2 其中一个为空时，继续处理剩下的链表。
 *      遍历结束后，如果 carry > 0，则需要额外创建一个节点存储 carry。
 * 时间复杂度分析：
 *      设 n 为 l1 的长度，m 为 l2 的长度，需要遍历 max(n, m) 次，因此时间复杂度为 O(max(n, m))。
 *      空间复杂度为 O(max(n, m))（新建链表存储结果）。
 */
public class Lc2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  // 创建一个虚拟头结点
        ListNode current = dummyHead;  // 当前节点指针，指向最终结果链表的末尾
        int carry = 0;  // 进位

        // 处理两个链表的每一位数字，直到遍历完所有节点
        while (l1 != null || l2 != null || carry != 0) {
            // 如果 l1 或 l2 的某个链表还有节点，就取出该节点的值，否则为 0
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // 计算当前位的和，并考虑进位
            int sum = val1 + val2 + carry;
            carry = sum / 10;  // 计算进位
            int digit = sum % 10;  // 计算当前位的数字

            // 创建新的节点，将计算结果添加到结果链表
            current.next = new ListNode(digit);
            current = current.next;  // 移动当前节点指针

            // 如果 l1 或 l2 还有节点，继续向下遍历
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;  // 返回结果链表的头结点
    }
}
