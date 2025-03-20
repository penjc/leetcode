package leedcode.双指针;

import java.util.Scanner;

/**
 * 11. 盛最多水的容器
 * 题目描述：
 * 给定一个数组 height，其中 height[i] 代表第 i 根垂线的高度，每根垂线的横坐标是 i，纵坐标是 height[i]。我们要找到两根垂线，使得它们与 x 轴围成的容器可以容纳最多的水，并返回最大存水量。
 * 解题思路：
 *      使用双指针从两端向中间收缩，以 O(n) 时间复杂度解决问题：
 *      初始化：
 *          左指针 left = 0（指向最左侧）。
 *          右指针 right = n-1（指向最右侧）。
 *          维护 maxArea 记录最大存水量。
 *      计算当前面积：
 *          area = min(height[left], height[right]) * (right - left) 。
 *          更新 maxArea。
 *      移动指针：
 *          移动较短的一侧（短板效应）：因为水的高度由 min(height[left], height[right]) 决定，所以我们希望找更高的线来增大面积。
 *          如果 height[left] < height[right]，移动 left++。
 *          否则移动 right--。
 *      终止条件：
 *          left >= right，结束循环。
 * 复杂度分析
 * 时间复杂度：O(n)，每个元素最多被访问一次（指针从两端向中间收缩）。
 * 空间复杂度：O(1)，只使用了两个额外变量。
 */
public class Lc11 {
    public static int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int cur = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, cur);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String[] s = nextLine.split(" ");
        int[] height = new int[s.length];
        for(int i = 0; i < s.length; i++){
            height[i] = Integer.parseInt(s[i]);
        }
        System.out.println(maxArea(height));
    }
}
