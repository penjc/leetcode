package leedcode.普通数组;

/**
 * 287. 寻找重复数
 * 题目描述：
 *      给定一个包含 n + 1 个整数的数组 nums，其整数都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 解题思路：
 *      快慢指针：
 *      1. 由于数组中的元素在 1 到 n 之间，所以可以将数组看成链表，数组的下标是链表的节点，数组的值是下一个节点的指针；
 *      2. 由于数组中至少有一个重复的元素，所以链表一定有环；
 *      3. 使用快慢指针，快指针每次走两步，慢指针每次走一步，直到两个指针相遇；
 *      4. 两个指针相遇时，将快指针重新指向头节点，然后快慢指针每次走一步，直到两个指针再次相遇；
 *      5. 两个指针相遇的节点就是环的入口，也就是重复的元素。
 */
public class Lc287 {

    public int findDuplicate(int[] nums) {
        // Step 1: 快慢指针相遇
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Step 2: 重新设置慢指针，找到入口
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
