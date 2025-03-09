package leedcode100.子串;
import java.util.*;

public class Lc239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 维护窗口范围：当队列头部的索引超出窗口左边界时，移除
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // 维护单调递减队列，确保队列中的元素从大到小排列
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 添加当前元素索引
            deque.offerLast(i);
            // 只有当 i >= k - 1 时，窗口才形成，可以开始收集结果
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}

