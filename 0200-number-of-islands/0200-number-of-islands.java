class Solution {
    public void dfs(int r,int c,char[][] grid,boolean[][] visited){
        
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length) return;
        if(grid[r][c]=='0' || visited[r][c]) return;

        visited[r][c]=true;

        dfs(r-1,c,grid,visited);
        dfs(r+1,c,grid,visited);
        dfs(r,c-1,grid,visited);
        dfs(r,c+1,grid,visited);   
    }
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int ans=0;

        boolean[][] visited=new boolean[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    ans++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return ans;
    }
}