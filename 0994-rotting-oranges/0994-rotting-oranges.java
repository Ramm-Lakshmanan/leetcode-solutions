class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue=new ArrayDeque<>();
        int tot_org=grid.length*grid[0].length;
        int tot_rot=0;

        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==2){
                    queue.offerLast(new int[]{r,c});
                    tot_rot++;
                }
                else if(grid[r][c]==0) tot_org--;
            }
        }

        if(tot_org==0) return 0;
        
        int ans=-1;
        
        int req=queue.size();
        int cur=0;

        while(!queue.isEmpty()){
            int[] temp=queue.pollFirst();
            cur++;
            int r=temp[0];
            int c=temp[1];
            if(r>0 && grid[r-1][c]==1){
                tot_rot++;
                grid[r-1][c]=2;
                queue.offerLast(new int[]{r-1,c});
            }
            if(r<grid.length-1 && grid[r+1][c]==1){
                tot_rot++;
                grid[r+1][c]=2;
                queue.offerLast(new int[]{r+1,c});
            }
            if(c>0 && grid[r][c-1]==1){
                tot_rot++;
                grid[r][c-1]=2;
                queue.offerLast(new int[]{r,c-1});
            }
            if(c<grid[0].length-1 && grid[r][c+1]==1){
                tot_rot++;
                grid[r][c+1]=2;
                queue.offerLast(new int[]{r,c+1});
            }

            if(cur==req){
                ans++;
                req=queue.size();
                cur=0;
            }
        }

        if(tot_rot==tot_org) return ans;
        return -1;
    }
}