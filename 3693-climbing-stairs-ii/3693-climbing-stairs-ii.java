class Solution {
    public int func(int idx,int n,int[] costs,int[] dp){
        if(idx==n) return 0;

        if(dp[idx]!=-1) return dp[idx];

        int min=Integer.MAX_VALUE;
        if(idx+1<=n) min=Math.min(min,1+costs[idx]+func(idx+1,n,costs,dp));
        if(idx+2<=n) min=Math.min(min,4+costs[idx+1]+func(idx+2,n,costs,dp));
        if(idx+3<=n) min=Math.min(min,9+costs[idx+2]+func(idx+3,n,costs,dp));

        return dp[idx]=min;
    }
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return func(0,n,costs,dp);
    }
}