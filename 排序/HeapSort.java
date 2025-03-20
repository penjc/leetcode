package 排序;

/**
 * 堆排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 * 原理：构建最大堆，然后交换堆顶(最大元素)和堆尾，重新构建调整堆
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 1. 构建最大堆 (Heapify 过程，从最后一个非叶子节点开始)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 2. 交换堆顶和堆尾，并缩小堆范围，重新调整
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0); // 重新堆化
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 设当前节点 i 为最大值
        int left = 2 * i + 1; // 左子节点
        int right = 2 * i + 2; // 右子节点

        // 如果左子节点存在且比当前最大值大，则更新最大值索引
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 如果右子节点存在且比当前最大值大，则更新最大值索引
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大值索引发生变化，则进行交换，并递归调整子树
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest); // 递归调整子树
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort(arr);
        System.out.println(java.util.Arrays.toString(arr)); // 输出排序后的数组
    }
}

