package leedcode100.双指针;

import java.util.Arrays;
import java.util.Scanner;

public class Lc283 {
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!= 0){
                nums[j++] = nums[i];
            }
        }
        while(j < nums.length){
            nums[j++] = 0;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        String[] s = nextLine.split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
