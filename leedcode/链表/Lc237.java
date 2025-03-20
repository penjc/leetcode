package leedcode.链表;

/**
 * 237. 删除链表中的节点
 * 题目描述：
 *      给定链表中的一个节点，要求在链表中删除该节点。
 * 解题思路：
 *      将当前节点的值替换为下一个节点的值，然后删除下一个节点。
 */
public class Lc237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
