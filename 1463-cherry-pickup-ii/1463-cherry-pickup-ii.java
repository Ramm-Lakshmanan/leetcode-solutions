class Solution {
    public int func(int r,int c1,int c2,int[][] grid,int[][][] dp){
        if(r==grid.length) return 0;

        if(dp[r][c1][c2]!=-1) return dp[r][c1][c2];

        int ans=grid[r][c1]+grid[r][c2];

        if(c1==c2) ans/=2;

        int max=0;

        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                if(c1+i<0 || c2+j<0 || c1+i>=grid[0].length || c2+j>=grid[0].length) continue;

                max=Math.max(max,func(r+1,c1+i,c2+j,grid,dp));
            }
        }

        return dp[r][c1][c2]=ans+max;
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length,m=grid[0].length;

        int[][][] dp=new int[n][m][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) Arrays.fill(dp[i][j],-1);
        }

        return func(0,0,m-1,grid,dp);
    }
}