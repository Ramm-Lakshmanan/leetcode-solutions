class Solution {
    public boolean func(int i,int j,int[][] grid,boolean[][] vis){
        if(grid[i][j]==1) return true;
        if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1) return false;
        if(vis[i][j]) return true;

        vis[i][j]=true;
        
        return func(i-1,j,grid,vis) & func(i+1,j,grid,vis) & func(i,j-1,grid,vis) & func(i,j+1,grid,vis);
    }
    public int closedIsland(int[][] grid) {
        int ans=0;
        boolean[][] vis=new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0 && !vis[i][j]){
                    if(func(i,j,grid,vis)==true) ans++;
                }
            }
        }
        return ans;
    }
}