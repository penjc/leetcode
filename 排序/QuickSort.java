package 排序;

/**
 * 快速排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(logn)
 * 稳定性：不稳定
 * 原理：选择一个基准元素，将小于基准元素的元素放在基准元素的左边，大于基准元素的元素放在基准元素的右边
 */
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(java.util.Arrays.toString(arr)); // 输出排序后的数组
    }
}

