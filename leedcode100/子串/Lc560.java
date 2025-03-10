package leedcode100.子串;

import java.util.HashMap;

/**
 * 利用前缀和：计算 sum 并存储在哈希表中。
 * 检查 sum - k 是否存在：如果存在，则累加 map[sum - k] 到 count。
 */
public class Lc560 {
    public int subarraySum(int[] nums, int k) {
        // 哈希表用来存储前缀和出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始时，前缀和为0出现一次
        map.put(0, 1);

        int count = 0;
        int sum = 0;

        // 遍历数组
        for (int num : nums) {
            sum += num;  // 更新当前的前缀和

            // 如果 sum - k 之前出现过，说明找到了一个和为 k 的子数组
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // 将当前前缀和的出现次数加1
            //如果 key 存在，则返回对应的值。
            //如果 key 不存在，则返回 defaultValue（而不会抛出 NullPointerException）。
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
