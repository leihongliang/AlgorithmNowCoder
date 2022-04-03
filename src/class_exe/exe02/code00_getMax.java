package class_exe.exe02;


import org.junit.Test;

public class code00_getMax {
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length-1);
    }
    public static int process(int[] arr, int L, int R){
        // 判断是否为叶子节点
        if (L == R) {
            return arr[L];
        }
        //
        int mid = L + (( R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid+1, R);
        return Math.max(leftMax, rightMax);
    }
    @Test
    public  void getMax() {
        int[] arr = {3,2,5,6,7,4 };
        int max = getMax(arr);
        System.out.println(max);
    }
    @Test
    public  void getMax2() {
        int[] arr = {1,2 };
        int max = getMax(arr);
        System.out.println(max);
    }
}
