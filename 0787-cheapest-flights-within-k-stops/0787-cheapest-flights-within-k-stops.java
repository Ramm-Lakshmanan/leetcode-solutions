class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<List<Integer>>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<flights.length;i++){
            List<Integer> temp=new ArrayList<>();
            temp.add(flights[i][1]);temp.add(flights[i][2]);
            adj.get(flights[i][0]).add(temp);
        }

        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int stops=0;
        dist[src]=0;

        Deque<int[]> q=new ArrayDeque<>();
        q.offerLast(new int[]{0,src});
        
        while(!q.isEmpty() && stops<=k){
            int size=q.size();
            while(size>0){
                int[] curr=q.pollFirst();
                int node=curr[1],cost=curr[0];

                for(List<Integer> next:adj.get(node)){
                    int nnode=next.get(0),ncost=next.get(1);

                    if(ncost+cost<dist[nnode]){
                        dist[nnode]=ncost+cost;
                        q.offerLast(new int[]{dist[nnode],nnode});
                    }
                }
                size--;
            }
            stops++;
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}