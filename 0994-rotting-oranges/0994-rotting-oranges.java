class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        Deque<int[]> q=new ArrayDeque<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) q.offer(new int[]{i,j});
            }
        }

        int time=0;

        while(!q.isEmpty()){
            int size=q.size();

            while(size>0){
                int[] cur=q.poll();

                int i=cur[0],j=cur[1];
                

                if(i>0 && grid[i-1][j]==1) {
                    q.offer(new int[]{i-1,j});
                    grid[i-1][j]=2;
                }
                if(j>0 && grid[i][j-1]==1) {
                    q.offer(new int[]{i,j-1});
                    grid[i][j-1]=2;
                }
                if(i<m-1 && grid[i+1][j]==1) {
                    grid[i+1][j]=2;
                    q.offer(new int[]{i+1,j});
                }
                if(j<n-1 && grid[i][j+1]==1) {
                    grid[i][j+1]=2;
                    q.offer(new int[]{i,j+1});
                }
                size--;
            }
            time++;
        }        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        System.out.println(time);
        return time==0?time:time-1;
    }
}