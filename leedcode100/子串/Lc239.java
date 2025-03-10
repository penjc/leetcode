package leedcode100.子串;
import java.util.*;

/**
 * 维护一个单调递减的双端队列：
 *     队列中的元素 存储索引，确保窗口滑动时能够正确移除过期元素。
 *     队列中的索引对应的值 保持单调递减，即：队首元素是窗口内的最大值。
 *     新元素入队时，移除所有比它小的元素（保持单调递减）。
 * 窗口滑动过程中：
 *     检查 队首是否过期（即索引是否超出窗口范围）。
 *     维护队列单调性，使最大值始终位于队首。
 *     每次窗口形成（i >= k - 1），将 队首元素（最大值）加入结果。
 */
public class Lc239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
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

