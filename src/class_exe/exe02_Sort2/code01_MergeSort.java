package class_exe.exe02_Sort2;

import org.junit.Test;

import java.util.Arrays;

public class code01_MergeSort {
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length-1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        // 左边有序，右边有序，整体融合
        process(arr, L, mid);
        process(arr, mid+1, R);
        merge(arr, L, mid, R);
    }

    // 把两个有序数组融合
    private static void merge(int[] arr, int L, int M, int R) {
        // 辅助空间，用完即释放
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        // 双指针，两个指针会比较大小，谁小拷贝谁，且+1
        // 条件是如果一边拷完，立马就跳出
        while (p1 <= M && p2 <= R) {
            help[i++] = (arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++]);
        }
        // 没有拷贝完的（大的那个），把剩下的数字拷进去
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        // 把辅助空间的数拷回原数组
        for (i = 0; i < help.length; i++){
            arr[L + i] = help[i];
        }
    }

    @Test
    public void margeSort() {
        int[] arr = {8,4,5,7,1,3,6,2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
