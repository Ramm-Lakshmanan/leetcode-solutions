class Solution {
    public int maxProduct(int[] nums) {
        int min=1,max=1,n=nums.length;
        int ans=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            ans=Math.max(ans,Math.max(min*nums[i],Math.max(nums[i],nums[i]*max)));

            int temp=max;
            max=Math.max(nums[i],Math.max(max*nums[i],min*nums[i]));
            min=Math.min(nums[i],Math.min(min*nums[i],temp*nums[i]));
        }

        return ans;
    }
}