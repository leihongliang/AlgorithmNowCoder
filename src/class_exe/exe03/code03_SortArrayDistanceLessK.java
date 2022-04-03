package class_exe.exe03;

import java.util.PriorityQueue;

//已知一个几乎有序的数组，几乎有序是指如果把数组排好序的话，每个元素移动的距离可以不超过K，并且K相对于数组来说比较小。
public class code03_SortArrayDistanceLessK {
    public static void sortArrayDistanceLessK(int[] arr, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        // 先放k个
        for (; index < Math.min(arr.length, k); index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,5,4,1,6,8,9,7};
        sortArrayDistanceLessK(a, 3);
        for(int i : a){
            System.out.print(i + " ");
        }
    }
}
