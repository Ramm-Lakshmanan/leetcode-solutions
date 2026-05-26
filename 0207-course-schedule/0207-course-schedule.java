class Solution {
    public boolean canFinish(int v, int[][] e) {
        List<List<Integer>> adj_list=new ArrayList<>();
        int[] indeg=new int[v];

        for(int i=0;i<v;i++) adj_list.add(new ArrayList<>());

        for(int i=0;i<e.length;i++){
            adj_list.get(e[i][1]).add(e[i][0]);
            indeg[e[i][0]]++;
        }

        Deque<Integer> queue=new ArrayDeque<>();

        for(int i=0;i<v;i++){
            if(indeg[i]==0) queue.offerLast(i);
        }

        int processed=0;

        while(!queue.isEmpty()){
            int node=queue.pollFirst();

            processed++;

            for(int neigh:adj_list.get(node)){
                indeg[neigh]--;
                if(indeg[neigh]==0) queue.offerLast(neigh);
            }
        }

        return processed==v;
    }
}