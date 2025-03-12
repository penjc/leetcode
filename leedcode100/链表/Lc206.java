package leedcode100.链表;


/**
 * 题目描述：
 *      反转链表，并返回反转后的链表。
 * 解题思路：
 *      使用双指针，一个指向前一个节点，一个指向当前节点。
 */
public class Lc206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // 记录下一个节点
            curr.next = prev; // 反转当前节点指向
            prev = curr; // 移动 prev 指针
            curr = nextTemp; // 移动 curr 指针
        }

        return prev; // 新的头节点
    }
}
