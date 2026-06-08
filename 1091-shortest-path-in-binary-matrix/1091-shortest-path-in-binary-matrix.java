class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        
        Deque<int[]> q=new ArrayDeque<>();
        q.offerLast(new int[]{1,0,0});
        grid[0][0]=1;

        while(!q.isEmpty()){
            int[] curr=q.pollFirst();
            int r=curr[1],c=curr[2],cost=curr[0];
            if(r==n-1 && c==n-1){
                return cost;
            }

            if(r>0 && grid[r-1][c]==0){
                q.offerLast(new int[]{cost+1,r-1,c});
                grid[r-1][c]=1;
            }
            if(c>0 && grid[r][c-1]==0){
                q.offerLast(new int[]{cost+1,r,c-1});
                grid[r][c-1]=1;
            }
            if(r<n-1 && grid[r+1][c]==0){
                q.offerLast(new int[]{cost+1,r+1,c});
                grid[r+1][c]=1;
            }
            if(c<n-1 && grid[r][c+1]==0){
                q.offerLast(new int[]{cost+1,r,c+1});
                grid[r][c+1]=1;
            }
            if(r>0 && c>0 && grid[r-1][c-1]==0){
                q.offerLast(new int[]{cost+1,r-1,c-1});
                grid[r-1][c-1]=1;
            }
            if(r<n-1 && c<n-1 && grid[r+1][c+1]==0){
                q.offerLast(new int[]{cost+1,r+1,c+1});
                grid[r+1][c+1]=1;
            }
            if(r>0 && c<n-1 && grid[r-1][c+1]==0){
                q.offerLast(new int[]{cost+1,r-1,c+1});
                grid[r-1][c+1]=1;
            }
            if(r<n-1 && c>0 && grid[r+1][c-1]==0){
                q.offerLast(new int[]{cost+1,r+1,c-1});
                grid[r+1][c-1]=1;
            }
        }
        return -1;
    }
}