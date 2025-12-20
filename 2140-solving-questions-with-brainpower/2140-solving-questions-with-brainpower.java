class Solution {
    public long ans(int n,int[][] questions,long[] dp){
        if(n==questions.length-1) return (long)questions[n][0];
        if(n>questions.length-1) return 0L;

        if(dp[n]!=-1L) return dp[n];
        long ch1=ans(n+1,questions,dp);
        long ch2=(long)questions[n][0]+ans(n+questions[n][1]+1,questions,dp);

        return dp[n]=Math.max(ch1,ch2);
    }
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] dp=new long[n];
        Arrays.fill(dp,-1L);
        return ans(0,questions,dp);
    }
}