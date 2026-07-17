class Solution {
    public int manhat(int[] x,int[] y){
        return Math.abs(x[0]-y[0])+Math.abs(y[1]-x[1]);
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j!=i){
                    int dis=manhat(points[i],points[j]);
                    adj.get(i).add(new int[]{j,dis});
                    adj.get(j).add(new int[]{i,dis});
                }

            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        boolean[] vis=new boolean[n];

        pq.offer(new int[]{0,0});
        int mst=0,size=0;

        while(!pq.isEmpty()){
            int[] node=pq.poll();
            if(vis[node[0]]) continue;

            mst+=node[1];
            vis[node[0]]=true;
            size++;

            for(int[] next:adj.get(node[0])){
                pq.offer(new int[]{next[0],next[1]});
            }
            
            if(size==n) return mst;
        }
        return mst;
    }
}