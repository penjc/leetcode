package leedcode100.链表;

public class Lc2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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
