class Solution {
    public int func(int cur,int end,int[] nums,int[] dp){
        if(cur<end) return 0;

        if(dp[cur]!=-1) return dp[cur];

        int take=nums[cur]+func(cur-2,end,nums,dp);
        int ntake=func(cur-1,end,nums,dp);

        return dp[cur]=Math.max(take,ntake);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp1=new int[n];
        int[] dp2=new int[n];

        Arrays.fill(dp1,-1);Arrays.fill(dp2,-1);

        int res1=func(n-1,1,nums,dp1);
        int res2=func(n-2,0,nums,dp2);

        return Math.max(res1,res2);
    }
}