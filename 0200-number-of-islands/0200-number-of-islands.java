class Solution {
    public void dfs(int i,int j,char[][] grid,boolean[][] vis){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0' || vis[i][j]) return;

        vis[i][j]=true;

        dfs(i-1,j,grid,vis);
        dfs(i,j-1,grid,vis);
        dfs(i+1,j,grid,vis);
        dfs(i,j+1,grid,vis);
    }
    public int numIslands(char[][] grid) {
        int m=grid.length,n=grid[0].length;

        boolean[][] visited=new boolean[m][n];
        int cnt=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    cnt++;
                    dfs(i,j,grid,visited);
                }
            }
        }

        return cnt;
    }
}