package leedcode.链表;

import java.util.HashMap;

/**
 * 题目描述：
 *      题目要求对一个带有随机指针 random 的单链表进行 深拷贝，即创建一个全新的链表，
 *      其中的每个节点都有和原链表相同的值，且 next 和 random 指针的关系也保持一致，但新链表的节点不能与原链表的节点混用。
 * 解题思路
 *      我们可以采用 哈希表 或 O(1) 额外空间的原地复制 进行求解。
 *      方法一：哈希表（O(n) 额外空间）
 *          第一遍遍历：使用一个 HashMap 存储原链表节点和新链表节点的映射关系，即 oldNode -> newNode。
 *          第二遍遍历：为新链表的 next 和 random 指针赋值，使它们与原链表一致。
 *          时间复杂度：O(n)，遍历两遍链表。
 *          空间复杂度：O(n)，需要额外的哈希表存储映射关系。
 *      方法二：O(1) 额外空间的原地复制
 *          第一遍遍历：在每个原链表节点 cur 之后，创建一个新的节点 newNode，并插入 cur.next 位置，使得链表结构变为 A → A' → B → B' → C → C'。
 *          第二遍遍历：为新节点设置 random 指针，例如 cur'->random = cur->random->next（若 cur.random 存在）。
 *          第三遍遍历：拆分链表，将新节点从原链表中分离出来，恢复原链表，并得到新链表。
 *          时间复杂度：O(n)，需要三次遍历。
 *          空间复杂度：O(1)，不需要额外的数据结构。
 */

public class Lc138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 方法一：哈希表（O(n) 额外空间）
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 使用 HashMap 存储 原节点 -> 新节点 的映射
        HashMap<Node, Node> map = new HashMap<>();

        // 第一遍遍历：复制所有节点，并存入 HashMap
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 第二遍遍历：设置新链表的 next 和 random 指针
        cur = head;
        while (cur != null) {
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);  // 复制 next 指针
            copy.random = map.get(cur.random);  // 复制 random 指针
            cur = cur.next;
        }

        return map.get(head);
    }

    // 方法二：O(1) 额外空间的原地复制
    public Node copyRandomList2(Node head) {
        if (head == null) return null;

        // 1. 复制每个节点，并插入到原节点之后
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        // 2. 复制 random 指针
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 3. 拆分链表
        Node dummy = new Node(0);
        Node newCur = dummy, oldCur = head;
        while (oldCur != null) {
            newCur.next = oldCur.next;
            newCur = newCur.next;
            oldCur.next = newCur.next;
            oldCur = oldCur.next;
        }

        return dummy.next;
    }
}
