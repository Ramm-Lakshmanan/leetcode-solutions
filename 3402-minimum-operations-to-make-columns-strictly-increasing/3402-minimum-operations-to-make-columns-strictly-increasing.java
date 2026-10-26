class Solution {
    public int minimumOperations(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                if(grid[j-1][i]>=grid[j][i]){
                    ans+=grid[j-1][i]-grid[j][i]+1;
                    grid[j][i]=grid[j-1][i]+1;
                }
            }
        }
        return ans;
    }
}