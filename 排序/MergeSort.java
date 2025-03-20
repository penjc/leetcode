package 排序;

/**
 * 归并排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * 稳定性：稳定
 * 原理：分治法，将数组分为两部分，分别排序，然后合并
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // 左子数组长度
        int n2 = right - mid;    // 右子数组长度

        int[] L = new int[n1]; // 创建左子数组
        int[] R = new int[n2]; // 创建右子数组

        System.arraycopy(arr, left, L, 0, n1); // 复制数据到左数组
        System.arraycopy(arr, mid + 1, R, 0, n2); // 复制数据到右数组

        int i = 0, j = 0, k = left; // `i` 遍历左数组, `j` 遍历右数组, `k` 记录合并位置

        // 归并：从两个子数组中取较小的元素放入原数组
        while (i < n1 && j < n2) {
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }

        // 复制剩余元素（如果有的话）
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(java.util.Arrays.toString(arr)); // 输出排序后的数组
    }
}

