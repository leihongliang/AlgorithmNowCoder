package Leetcode101.chapter10;

import java.util.Arrays;

public class class1 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,2,3};
        swap(arr,1,2);
        System.out.println("swap : "+Arrays.toString(arr));
        System.out.println("printOddTimesNum1 : "+printOddTimesNum1(arr));
        int arr2[] = {1,2,3,2,3,4};
        printOddTimesNum2(arr2);
    }
    /**
     * 交换i和j位置上的值
     */
    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 一种数为奇数，其他为偶数
     * @return 唯一那个奇数
     */
    public static int printOddTimesNum1(int[] arr){
        int eor = 0;
        for (int cur : arr){
            eor ^= cur;
        }
        return eor;
    }

    /**
     * 两种数为奇数，其他为偶数
     */
    public static void printOddTimesNum2(int[] arr){
        int eor = 0, onlyOne = 0;
        for (int curNum : arr){
            eor ^= curNum;
        }
        // eor = a^b ≠ 0 必有一位为1（必有一位不同）
        // 提取a^b最右1的位置（此位不同）
        int rightOne = eor & (~eor + 1);
        for (int cur : arr){
            // 最右那位为1，偶数次不干扰001 100
            if (((cur & rightOne) == 1)){
                onlyOne ^= cur;
            }
        }
        // a a^b^a
        System.out.println(onlyOne +" "+ (eor ^ onlyOne));;
    }
    /**
     * 插入排序
     */
    public static void insertSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        for (int i=1; i < arr.length; i++){
            for (int j = i -1; j >= 0 && arr[j] > arr[j + 1]; j--){
                swap(arr, j, j+1);
            }
        }
    }


}

