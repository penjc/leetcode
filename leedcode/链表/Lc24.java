package leedcode.链表;

/**
 * 题目描述：
 *      给定一个链表，两两交换其中 相邻的节点，并返回交换后的链表头节点。
 *      注意：不能修改节点的值，只能进行节点交换。
 * 解题思路：
 *      迭代解法：
 *      使用哨兵节点 (dummy) 作为新的头部，简化链表头节点的交换情况。
 *      维护一个 prev 指针，用于指向每次交换的前一个节点，初始指向 dummy。
 *      遍历链表，每次交换一对相邻节点：
 *      设 first 为 prev.next，second 为 first.next。
 *      让 prev.next 指向 second，first.next 指向 second.next，second.next 指向 first。
 *      更新 prev，继续处理下一对。
 * 时间复杂度：O(N)，每个节点只遍历一次。
 * 空间复杂度：O(1)，只用了几个指针变量。
 */
public class Lc24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;      // 第一个节点
            ListNode second = first.next;    // 第二个节点

            // 交换两个节点
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // 更新 prev 指针，继续处理下一对
            prev = first;
        }
        return dummy.next;
    }
}
