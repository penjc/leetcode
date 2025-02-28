package leedcode100.子串;

import java.util.HashMap;

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
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
