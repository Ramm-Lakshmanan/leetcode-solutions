class Solution {
    public int func(int idx,int buy,int[] prices,int[][] dp){
        if(idx==prices.length) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit=0;
        if(buy==0){
            profit=Math.max(func(idx+1,buy,prices,dp),-prices[idx]+func(idx+1,1,prices,dp));
        }
        else{
            profit=Math.max(func(idx+1,buy,prices,dp),prices[idx]+func(idx,0,prices,dp));
        }

        return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        return func(0,0,prices,dp);
    }
}