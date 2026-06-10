class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<List<Integer>>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<times.length;i++){
            List<Integer> temp=new ArrayList<>();
            temp.add(times[i][1]);temp.add(times[i][2]);
            adj.get(times[i][0]).add(temp);
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        pq.offer(new int[]{0,k});
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int cost=curr[0],node=curr[1];

            if(cost>dist[node]) continue;

            for(List<Integer> next:adj.get(node)){
                int ncost=next.get(1),nnode=next.get(0);

                if(ncost+cost<dist[nnode]){
                    dist[nnode]=ncost+cost;
                    pq.offer(new int[]{dist[nnode],nnode});
                }
            }
        }

        int max=Integer.MIN_VALUE;

        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}