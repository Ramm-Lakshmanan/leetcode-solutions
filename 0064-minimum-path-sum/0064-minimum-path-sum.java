class Solution {
    public int ans(int m,int n,int[][] grid,int[][] dp){
        if(m==0 && n==0) return grid[m][n];

        if(dp[m][n]!=-1) return dp[m][n];

        int ch1=Integer.MAX_VALUE;
        int ch2=Integer.MAX_VALUE;

        if(m>=1) ch1=grid[m][n]+ans(m-1,n,grid,dp);
        if(n>=1) ch2=grid[m][n]+ans(m,n-1,grid,dp);

        return dp[m][n]=Math.min(ch1,ch2);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return ans(m-1,n-1,grid,dp);
    }
}