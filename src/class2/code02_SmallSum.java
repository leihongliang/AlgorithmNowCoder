package class2;

public class code02_SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }
    // arr既要排好序，也要求小和
    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid)
                + mergeSort(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0, p1 = l, p2 = m + 1, res = 0;
        while (p1 <= m && p2 <= r) {
            // 并入的时候，利用有序性
            // eg.134和25,由1<2,推出2后面的数都>1,故直接(r-indexOf(2)+1)*1
            // 因为排好序，直接相减就能得出有多少个数比p1大
            // 左边比右边小才拷贝进小和
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        int smallSum = smallSum(arr);
        System.out.println(smallSum);
    }
}
