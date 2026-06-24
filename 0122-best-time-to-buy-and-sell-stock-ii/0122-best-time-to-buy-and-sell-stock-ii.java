class Solution {
    public int func(int idx,int max,int[] prices,int[] dp){
        if(idx==-1) return 0;

        if(dp[idx]!=-1) return dp[idx];

        max=Math.max(max,prices[idx]);
        int ch1=0,ch2=0;
        if(max>prices[idx]){
            ch1=max-prices[idx]+func(idx-1,prices[idx],prices,dp);
        }
        ch2=func(idx-1,max,prices,dp);

        return dp[idx]=Math.max(ch1,ch2);
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int max=0;
        for(int ele:prices) max=Math.max(max,ele);

        int[] dp=new int[n];
        Arrays.fill(dp,-1);

        return func(n-1,0,prices,dp);
    }
}