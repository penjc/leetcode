package leedcode100.链表;

/**
 * 题目描述：
 *      将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 解题思路：
 *      迭代解法：
 *      创建一个 dummy 伪头节点，并使用 curr 指针用于构建新链表。
 *      遍历 list1 和 list2，逐步选择较小的节点并连接到 curr。
 *      遍历结束后，将 curr.next 指向剩余未合并的链表（如果有）。
 *      返回 dummy.next 作为新链表头部。
 */
public class Lc21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // 连接剩余部分
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;
    }
}
