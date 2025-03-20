package leedcode.链表;


/**
 * 题目描述：
 *      我们需要找到两个单链表 headA 和 headB 相交的起始节点。
 *      如果两个链表没有相交，则返回 null。
 * 解题思路：
 *      使用双指针
 *      两个指针分别从两个链表的头部开始遍历，当一个指针遍历完一个链表后，就跳到另一个链表的头部继续遍历。
 *      如果两个链表相交，那么两个指针会在相交的节点相遇。
 *      如果无交点，他们会同时变成 null。
 */
public class Lc160 {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            ListNode pA = headA, pB = headB;

            // 两个指针遍历链表
            while (pA != pB) {
                // pA 走完 A 后跳到 B，pB 走完 B 后跳到 A
                pA = (pA == null) ? headB : pA.next;
                pB = (pB == null) ? headA : pB.next;
            }

            return pA; // 相交返回交点，不相交返回 null
        }
    }
