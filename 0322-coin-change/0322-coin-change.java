class Solution {
    // public int func(int amount,int[] coins,int[] dp){
    //     if(amount<0) return Integer.MAX_VALUE;
    //     if(amount==0) return 0;

    //     if(dp[amount]!=-1) return dp[amount];

    //     int ans=Integer.MAX_VALUE;

    //     for(int coin:coins){
    //         int res=func(amount-coin,coins,dp);
    //         if(res!=Integer.MAX_VALUE) ans=Math.min(ans,1+res);
    //     }
    //     return dp[amount]=ans;
    // }
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];

        for(int i=1;i<=amount;i++){
            int res=Integer.MAX_VALUE;
            for(int coin:coins){
                if(i-coin>=0 && dp[i-coin]!=Integer.MAX_VALUE){
                    res=Math.min(res,1+dp[i-coin]);
                }
            }
            dp[i]=res;

        }
        if(dp[amount]==Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}