class Solution {
    public long func(int i,int j,int[][] grid){
        if(grid[i][j]==0) return 0L;
        
        long sum=grid[i][j];
        grid[i][j]=-1;

        if(i>0 && grid[i-1][j]>0) sum+=func(i-1,j,grid);
        if(j>0 && grid[i][j-1]>0) sum+=func(i,j-1,grid);
        if(i<grid.length-1 && grid[i+1][j]>0) sum+=func(i+1,j,grid);
        if(j<grid[0].length-1 && grid[i][j+1]>0) sum+=func(i,j+1,grid);

        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length,ans=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    if(func(i,j,grid)%(long)k==0) ans++;
                }
            }
        }
        return ans;
    }
}