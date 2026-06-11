class Solution {
    public int func(int x,int y1,int y2,int[][] grid,int[][][] dp){
        
        if(x==grid.length)
            return 0;
        
        if(dp[x][y1][y2]!=-1) return dp[x][y1][y2];

        int[][] d={{1,-1},{1,0},{1,1}};

        int curr=grid[x][y1]+grid[x][y2];

        if(y1==y2) curr/=2;

        int max=Integer.MIN_VALUE;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int nx=x+d[i][0],ny1=y1+d[i][1];
                int ny2=y2+d[j][1];

                if(nx>grid.length || ny1>=grid[0].length || ny2>=grid[0].length || ny1<0 || ny2<0) continue;

                max=Math.max(max,func(nx,ny1,ny2,grid,dp));
            }
        }

        if(max!=Integer.MIN_VALUE) curr+=max;
        return dp[x][y1][y2]=curr;
    }
    public int cherryPickup(int[][] grid) {
        int row=grid.length,col=grid[0].length;

        int[][][] dp=new int[row][col][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++) Arrays.fill(dp[i][j],-1);
        }

        int x=0,y1=0,y2=col-1;

        return func(x,y1,y2,grid,dp);        
    }
}