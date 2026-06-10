class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row=heights.length,col=heights[0].length;
        int[][] dist=new int[row][col];
        for(int i=0;i<row;i++)Arrays.fill(dist[i],Integer.MAX_VALUE);

        int[][] d={{1,0},{0,1},{-1,0},{0,-1}};

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int cost=curr[0],x=curr[1],y=curr[2];

            if(cost>dist[x][y]) continue;
            if(x==row-1 && y==col-1) return cost;
            for(int i=0;i<4;i++){
                if(x+d[i][0]>=0 && x+d[i][0]<row && y+d[i][1]>=0 && y+d[i][1]<col && Math.max(cost,Math.abs(heights[x][y]-heights[x+d[i][0]][y+d[i][1]]))<dist[x+d[i][0]][y+d[i][1]]){
                    dist[x+d[i][0]][y+d[i][1]]=Math.max(cost,Math.abs(heights[x][y]-heights[x+d[i][0]][y+d[i][1]]));
                    pq.offer(new int[]{dist[x+d[i][0]][y+d[i][1]],x+d[i][0],y+d[i][1]});
                }
            }
        }
        if(dist[row-1][col-1]==Integer.MAX_VALUE) return 0;
        return dist[row-1][col-1];
    }
}