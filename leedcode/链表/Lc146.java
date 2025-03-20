package leedcode.链表;

import java.util.*;

/**
 * 题目描述：
 *      LRU（Least Recently Used，最近最少使用）缓存是一种缓存淘汰策略，要求当缓存达到容量上限时，删除最近最少使用的元素。
 *      get(int key)：如果 key 存在于缓存中，则返回对应的 value，否则返回 -1。访问 key 后，该 key 需要被标记为最近使用的。
 *      put(int key, int value)：
 *      如果 key 存在，更新其 value，并将其标记为最近使用的。
 *      如果 key 不存在，则插入新 key-value 对。如果缓存已满，则移除最近最少使用的 key。
 *      此外，get 和 put 操作的时间复杂度必须是 O(1)。
 * 解题思路：
 *      结合 哈希表 (HashMap) + 双向链表 (Doubly Linked List) 实现：
 *      哈希表 (HashMap):
 *          用于在 O(1) 时间复杂度内查找 key 是否存在，并获取节点位置。
 *          key 映射到双向链表中的节点（Node）。
 *      双向链表 (Doubly Linked List):
 *          维护访问顺序，最近使用的节点放在链表头部，最久未使用的节点放在链表尾部。
 *          每次 get 或 put 时，将访问的 key 对应的节点移动到链表头部（表示最近使用）。
 *          当缓存满时，删除链表尾部的节点（最近最少使用的元素）。
 */
public class Lc146 {

    class LRUCache {
        private class Node {
            int key, value;
            Node prev, next;
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private final Map<Integer, Node> cache;
        private final Node head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();

            // 伪头部和伪尾部，简化边界操作
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) return -1;

            Node node = cache.get(key);
            moveToHead(node); // 标记为最近使用
            return node.value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                if (cache.size() >= capacity) {
                    removeLeastUsed();
                }
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void removeLeastUsed() {
            Node leastUsed = tail.prev;
            removeNode(leastUsed);
            cache.remove(leastUsed.key);
        }
    }

}
