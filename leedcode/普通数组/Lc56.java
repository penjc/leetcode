package leedcode.普通数组;

import java.util.*;

/**
 * 先按区间的起点 start 进行排序：
 *      这样可以保证重叠的区间相邻，方便后续合并。
 * 遍历排序后的区间数组 intervals：
 *      用一个 merged 列表来存储合并后的区间。
 *      判断当前区间与 merged 列表最后一个区间是否重叠：
 *          如果重叠（当前区间 start <= merged 最后一个区间的 end）：合并区间，更新 end。
 *          如果不重叠：直接加入 merged。
 * 返回 merged 作为最终的合并区间结果。
 */
public class Lc56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];

        // 1. 按区间起点 start 排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        // 2. 遍历区间数组
        for (int[] interval : intervals) {
            // merged 为空，或者当前区间与 merged 最后一个区间不重叠
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // 发生重叠，合并区间
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // 3. 返回合并后的区间数组
        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args) {
        Lc56 solution = new Lc56();
        int[][] intervals = {{1,3},{15,18},{2,6},{8,10}};
        System.out.println(Arrays.deepToString(solution.merge(intervals)));
    }
}

