class Solution {
    /*public int ans(int n,int[] nums,int[] dp){
        if(n==0) return nums[0];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int pick=nums[n]+ans(n-2,nums,dp);
        int non_pick=ans(n-1,nums,dp);

        return dp[n]=Math.max(pick,non_pick);
    }*/
    public int rob(int[] nums) {
        int n=nums.length;
        int prev1=nums[0];
        int prev2=0;
        int curr;
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>=2) pick+=prev2;
            int non_pick=prev1;
            curr=Math.max(pick,non_pick);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}