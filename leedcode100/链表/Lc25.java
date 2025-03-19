package leedcode100.链表;

/**
 * 题目描述：
 *      给定一个链表，每 k 个节点一组进行翻转，并返回修改后的链表。
 *      k 是一个正整数，且小于或等于链表的长度。如果节点总数不是 k 的整数倍，则保持剩余部分的节点顺序不变。
 *      你不能只改变节点内部的值，而是需要实际进行节点交换。
 * 解题思路
 *      找到 k 个一组的子链表
 *          遍历链表，找到 k 个节点 的一组，进行翻转。
 *          如果剩余节点不足 k，则不翻转。
 *      翻转 k 个节点
 *          采用 头插法（即逐个反转），使 k 个节点按顺序倒置。
 *      递归 or 迭代
 *          递归解法：找到 k 个节点后翻转，然后递归处理剩余部分。
 *          迭代解法（推荐）：遍历链表时进行 k 组翻转，并动态连接新链表。
 */
public class Lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // 检查是否剩余 k 个节点
            ListNode kthNode = prevGroupEnd;
            for (int i = 0; i < k; i++) {
                kthNode = kthNode.next;
                if (kthNode == null) return dummy.next; // 剩余不足 k 个，不翻转
            }

            // 记录翻转前的头部和尾部
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = kthNode.next;

            // 翻转 k 个节点
            ListNode prev = groupEnd, currNode = groupStart;
            while (currNode != groupEnd) {
                ListNode nextNode = currNode.next;
                currNode.next = prev;
                prev = currNode;
                currNode = nextNode;
            }

            // 连接翻转后的部分
            prevGroupEnd.next = prev;
            prevGroupEnd = groupStart; // 更新 prevGroupEnd 指向新的结尾
        }
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = head;

        // k 个一组处理
        for (; n >= k; n -= k) {
            for (int i = 0; i < k; i++) {
                ListNode nxt = cur.next;
                cur.next = pre; // 每次循环只修改一个 next，方便大家理解
                pre = cur;
                cur = nxt;
            }

            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
/**
 * 处理剩余不足 k 个的部分(如果剩余不足 k 个也要翻转)
 */
//        pre = null;
//        for(int i =0;i<n;i++){
//            ListNode nxt = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = nxt;
//        }
//        p0.next = pre;

        return dummy.next;
    }
}
