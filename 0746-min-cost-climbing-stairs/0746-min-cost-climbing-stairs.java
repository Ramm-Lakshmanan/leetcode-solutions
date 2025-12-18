class Solution {
    /*public int ans(int n,int[] cost,int[] dp){
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
    }*/
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int prev2=cost[0];
        int prev1=cost[1];
        int curr;
        for(int i=2;i<=n;i++){
            int ch1,ch2;
            if(i==n){
                ch1=prev1;
                ch2=prev2;
            }
            else{
                ch1=cost[i]+prev1;
                ch2=cost[i]+prev2;
            }
            curr=Math.min(ch1,ch2);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}