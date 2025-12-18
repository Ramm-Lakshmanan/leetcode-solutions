class Solution {
    public int ans(int n,int[] cost,int[] dp){
        if(n<=1) return cost[n];
        if(dp[n]!=-1) return dp[n];
        int ch1,ch2;
        if(n==cost.length){
            ch1=ans(n-1,cost,dp);
            ch2=ans(n-2,cost,dp);
        } 
        else{
            ch1=cost[n]+ans(n-1,cost,dp);
            ch2=cost[n]+ans(n-2,cost,dp);
        }
        return dp[n]=Math.min(ch1,ch2);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);

        return ans(n,cost,dp);
    }
}