class Solution {
    long mod=1000000007;
    public int func(int x,int i,int j,int[][] grid,int[][][] dp){
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return 0;

        if(i==grid.length-1 && j==grid[0].length-1) return 1;

        if(dp[i][j][x]!=-1) return dp[i][j][x];
        int ans;
        if(grid[i][j]==0){
            ans=(int)(((long)func(1,i+1,j,grid,dp)+(long)func(0,i,j+1,grid,dp))%mod);
        }
        else{
            if(x==1) ans=(int)(((long)func(0,i,j+1,grid,dp))%mod);
            else ans=(int)(((long)func(1,i+1,j,grid,dp))%mod);
        }
        return dp[i][j][x]=ans;
    }
    public int uniquePaths(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][][] dp=new int[m][n][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) Arrays.fill(dp[i][j],-1);
        }

        return (int)((func(0,0,1,grid,dp)+func(1,1,0,grid,dp))%mod);
    }
}