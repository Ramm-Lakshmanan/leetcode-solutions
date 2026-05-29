class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] ans=new int[nums.length];
        int k1=0,k2=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0) ans[k1++]=nums[i];
            else ans[k2--]=nums[i];
        }
        return ans;
    }
}