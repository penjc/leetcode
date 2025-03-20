package leedcode.链表;

/**
 * 82. 删除排序链表中的重复元素 II
 * 题目描述：
 *      给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 * 解题思路：
 *      1. 使用 dummy 节点，避免处理头节点的特殊情况；
 *      2. 使用 cur 指针遍历链表，判断 cur.next 和 cur.next.next 是否相等；
 *      3. 如果相等，说明有重复元素，删除重复元素；
 */
public class Lc82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            if (cur.next.next.val == val) {
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
