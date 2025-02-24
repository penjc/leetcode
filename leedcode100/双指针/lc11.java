package leedcode100.双指针;

import java.util.Scanner;

/**
 * author peng
 * description
 * date 2025/2/22
 */
public class lc11 {
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
