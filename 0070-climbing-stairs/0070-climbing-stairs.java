class Solution {

    public int fib(int[] dp,int n){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fib(dp,n-1)+fib(dp,n-2);
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+2];
        Arrays.fill(dp,-1);
        return fib(dp,n+1);
    }
}