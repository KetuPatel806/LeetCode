import java.util.Arrays;

public class Leetcode268 {
    public static void main(String[] args) {
        int[] nums ={3,0,1};
        System.out.println(findMissing(nums));
    }
    public static int findMissing(int[] nums){
        int i=0;
        while(i<nums.length){
            int correctIndex = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[correctIndex]){
                swap(nums,i,correctIndex);
            }
            else{
                i++;
            }
        }
        for(int j=0;j< nums.length;j++){
            if(nums[j] != j){
                return j;
            }
        }
        return nums.length;
    }
    public static void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start] =nums[end];
        nums[end] = temp;
    }
}
