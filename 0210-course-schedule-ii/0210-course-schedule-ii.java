class Solution {
    public int[] findOrder(int v, int[][] e) {
        int[] ans=new int[v];
        List<List<Integer>> adj_list=new ArrayList<>();
        Deque<Integer> q=new ArrayDeque<>();
        int[] in_deg=new int[v];

        for(int i=0;i<v;i++){
            adj_list.add(new ArrayList<>());
        }

        for(int i=0;i<e.length;i++){
            adj_list.get(e[i][1]).add(e[i][0]);
            in_deg[e[i][0]]++;            
        }

        for(int i=0;i<v;i++){
            if(in_deg[i]==0) q.offerLast(i);
        }

        int cnt=0;

        while(!q.isEmpty()){
            int node=q.pollFirst();
            ans[cnt]=node;
            cnt++;

            for(int neigh:adj_list.get(node)){
                in_deg[neigh]--;

                if(in_deg[neigh]==0){
                    q.offerLast(neigh);
                }
            }
        }

        if(cnt==v) return ans;
        return new int[]{};
    }
}