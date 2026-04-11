class Solution {
    public int func(int amount,int[] dp,int[] coins){
        if(amount==0) return 0;
        else if(amount<0) return Integer.MIN_VALUE;

        if(dp[amount]!=Integer.MAX_VALUE) return dp[amount];

        int min=Integer.MAX_VALUE;
        for(int coin:coins){
            int curr=func(amount-coin,dp,coins);
            if(curr!=Integer.MIN_VALUE && curr!=-1) min=Math.min(min,1+curr);
        }

        if(min==Integer.MAX_VALUE) return dp[amount]=-1;
        return dp[amount]=min;
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        return func(amount,dp,coins);
    }
}