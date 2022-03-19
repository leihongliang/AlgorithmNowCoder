package A;

public class a2_35 {
    public static void main(String[] args) {
        int[] a = {2,3,5,6};
        Solution1_2 solution = new Solution1_2();
        int result;
        result = solution.searchInsert(a,1);
        System.out.println(result);
    }
}
class Solution1 {
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }else if(nums[i]>target){
                return i;
            }
        }
        return nums.length;
    }
}
class Solution1_1 {
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
}

class Solution1_2 {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int left=0,right=n-1;
        while(left <= right){
            int mid=(right-left)/2+left;
            if(nums[mid] < target){
                left = mid+ 1;
            }else if(nums[mid] > target){
                right = mid- 1;
            }else{
                return mid;
            }
        }
        return left;
    }
}