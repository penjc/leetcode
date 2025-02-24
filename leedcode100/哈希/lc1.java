package leedcode100.哈希;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * author peng
 * description
 * date 2025/2/21
 */
public class lc1 {
    public static int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int another = target - nums[i];
            Integer anotherIndex = map.get(another);
            if(anotherIndex != null){
                res[0] = i;
                res[1] = anotherIndex;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputArr = input.split(" ");
        int[] nums = new int[inputArr.length];
        for(int i = 0; i < inputArr.length; i++){
            nums[i] = Integer.parseInt(inputArr[i]);
        }
        int target = sc.nextInt();
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);

    }
}
