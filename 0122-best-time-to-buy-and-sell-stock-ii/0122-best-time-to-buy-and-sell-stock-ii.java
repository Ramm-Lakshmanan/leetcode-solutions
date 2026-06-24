class Solution {
    // public int func(int idx,int max,int[] prices,int[] dp){
    //     if(idx==-1) return 0;

    //     if(dp[idx]!=-1) return dp[idx];

    //     max=Math.max(max,prices[idx]);
    //     int ch1=0,ch2=0;
    //     if(max>prices[idx]){
    //         ch1=max-prices[idx]+func(idx-1,prices[idx],prices,dp);
    //     }
    //     ch2=func(idx-1,max,prices,dp);

    //     return dp[idx]=Math.max(ch1,ch2);
    // }
    public int maxProfit(int[] prices) {
        int n=prices.length;

        int profit=0;
        int max=prices[n-1];

        for(int i=n-2;i>=0;i--){
            if(prices[i]>max) max=prices[i];
            else{
                profit+=(max-prices[i]);
                max=prices[i];
            }
        }
        return profit;
    }
}