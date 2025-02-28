package leedcode100.双指针;

import java.util.*;

public class Lc15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 如果数组长度小于3，直接返回空
        if (nums == null || nums.length < 3) {
            return result;
        }

        // 排序数组
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 双指针法
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 找到一个三元组，添加到结果中
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复的左指针和右指针元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 移动指针
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 如果和小于0，左指针右移
                    left++;
                } else {
                    // 如果和大于0，右指针左移
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        String[] s = nextLine.split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
}
