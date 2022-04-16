package basic_class_04.exe;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] a= arr;
        a[1] = 5;
        a[3] = arr[0];
        System.out.println(Arrays.toString(arr));
    }



}

