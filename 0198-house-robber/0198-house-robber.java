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
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];

        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>=2) pick+=dp[i-2];
            int non_pick=dp[i-1];
            dp[i]=Math.max(pick,non_pick);
        }
        return dp[n-1];
    }
}