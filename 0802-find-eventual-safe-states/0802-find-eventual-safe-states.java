class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<List<Integer>> rev=new ArrayList<>();
        int v=graph.length;
        int[] outdeg=new int[v];
        List<Integer> ans=new ArrayList<>();
        boolean[] vis=new boolean[v];

        for(int i=0;i<v;i++) {
            rev.add(new ArrayList<>());
        }
        Deque<Integer> q=new ArrayDeque<>();

        for(int i=0;i<v;i++){
            for(int j:graph[i]){
                rev.get(j).add(i);
                outdeg[i]++;
            }
        }

        for(int i=0;i<v;i++){
            if(outdeg[i]==0) q.offerLast(i);
        }

        while(!q.isEmpty()){
            int node=q.pollFirst();
            vis[node]=true;

            for(int i:rev.get(node)){
                outdeg[i]--;
                if(outdeg[i]==0) q.offerLast(i);
            }
        }
        
        for(int i=0;i<v;i++){
            if(vis[i]) ans.add(i);
        }
        return ans;
    }
}