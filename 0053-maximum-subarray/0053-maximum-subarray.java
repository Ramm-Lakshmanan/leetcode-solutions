class Solution {
    public int maxSubArray(int[] nums) {
        int cur=nums[0],max=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            cur=Math.max(cur+nums[i],nums[i]);
            max=Math.max(cur,max);
        }
        return max;
    }
}