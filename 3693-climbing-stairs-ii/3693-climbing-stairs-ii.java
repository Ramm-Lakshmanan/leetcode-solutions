class Solution {
    /*public int ans(int n,int costs[],int[] dp){
        if(n==-1) return 0;

        if(dp[n]!=-1) return dp[n];
        int ch1=costs[n]+1+ans(n-1,costs,dp);
        int ch2=Integer.MAX_VALUE,ch3=Integer.MAX_VALUE;
        if(n>=1) ch2=costs[n]+4+ans(n-2,costs,dp);
        if(n>=2) ch3=costs[n]+9+ans(n-3,costs,dp);

        return dp[n]=Math.min(Math.min(ch1,ch2),ch3);
    }*/
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int ch1=Integer.MAX_VALUE,ch2=Integer.MAX_VALUE,ch3=Integer.MAX_VALUE;
            ch1=dp[i-1]+costs[i-1]+1;
            if(i>=2) ch2=costs[i-1]+4+dp[i-2];
            if(i>=3) ch3=costs[i-1]+9+dp[i-3];
            dp[i]=Math.min(Math.min(ch1,ch2),ch3);
        }
        return dp[n];
    }
}