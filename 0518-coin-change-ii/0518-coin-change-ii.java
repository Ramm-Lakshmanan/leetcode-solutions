class Solution {
    public int func(int amount,int[] coins,int start,int[][] dp){
        if(amount==0) return 1;

        if(start==coins.length || amount<0) return 0;
        
        if(dp[start][amount]!=-1) return dp[start][amount];
        int c=0;
        for(int i=start;i<coins.length;i++){
            c+=func(amount-coins[i],coins,i,dp);
        }
        return dp[start][amount]=c;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];

        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        return func(amount,coins,0,dp);
    }
}