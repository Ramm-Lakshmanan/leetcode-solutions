class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[] dp=new int[n];
        
        for(int i=0;i<n;i++){
            dp[i]=grid[0][i];
            if(i>0) dp[i]+=dp[i-1];
        }

        for(int i=1;i<m;i++){
            int[] temp=new int[n];
            temp[0]=dp[0]+grid[i][0];
            for(int j=1;j<n;j++){
                temp[j]=Math.min(temp[j-1],dp[j])+grid[i][j];
            }
            dp=temp;
        }
        return dp[n-1];
    }
}