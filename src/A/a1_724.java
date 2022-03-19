package A;

import java.util.Arrays;

public class a1_724 {
    public static void main(String[] args) {
        int[] a = {1,7,3,6,5,6};
//        int[] a = {1,2,3};
        Solution solution = new Solution();
        int result;
        result = solution.pivotIndex(a);
        System.out.println(result);
    }
}
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0,flag=0;
        for(int i= 0; i< nums.length; i++){
            sum += nums[i];
        }
        for(int j= 0; j< nums.length; j++){
            flag += nums[j];
            if((flag*2- nums[j]) == sum){
                return j;
            }
        }
        return -1;
    }
}