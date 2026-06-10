class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<List<Integer>>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<flights.length;i++){
            List<Integer> temp=new ArrayList<>();
            temp.add(flights[i][1]);temp.add(flights[i][2]);
            adj.get(flights[i][0]).add(temp);
        }

        int[][] dist=new int[n][k+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dist[i],Integer.MAX_VALUE);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        pq.offer(new int[]{0,src,0});
        dist[src][0]=0;

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            if(curr[2]>k) continue;
            int cost=curr[0],node=curr[1],stop=curr[2];

            for(List<Integer> now:adj.get(node)){
                int nnode=now.get(0),ncost=now.get(1);
                if(ncost+cost<dist[nnode][stop]){
                    dist[nnode][stop]=ncost+cost;
                    pq.offer(new int[]{dist[nnode][stop],nnode,stop+1});
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<k+1;i++) ans=Math.min(ans,dist[dst][i]);
        
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}