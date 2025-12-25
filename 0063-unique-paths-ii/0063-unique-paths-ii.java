class Solution {
    /*public int ans(int m,int n,int[][] obstacleGrid,int[][] dp){
        if(obstacleGrid[m][n]==1){
            return 0;
        }
        else if(m==0) return dp[0][n];
        else if(n==0) return dp[m][0];

        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n]=ans(m-1,n,obstacleGrid,dp)+ans(m,n-1,obstacleGrid,dp);
    }*/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        boolean flag=false;
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==1 || flag) {dp[0][i]=0; flag=true;}
            else dp[0][i]=1;
        }
        flag=false;
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1 || flag) {dp[i][0]=0; flag=true;}
            else dp[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}