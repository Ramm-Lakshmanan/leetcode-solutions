class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int left=0,right=n-1;

        while(left<right){
            if(nums[right]+nums[left]==target) return new int[]{left+1,right+1};
            
            else if(nums[right]+nums[left]>target) right--;
            else left++;
        }
        return new int[]{0,0};
    }
}