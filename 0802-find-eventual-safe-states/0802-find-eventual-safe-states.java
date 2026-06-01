class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj=new ArrayList<>();
        List<List<Integer>> rev=new ArrayList<>();
        int v=graph.length;

        for(int i=0;i<v;i++) {
            adj.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }

        Set<Integer> ans=new HashSet<>();
        Deque<Integer> q=new ArrayDeque<>();

        for(int i=0;i<v;i++){
            for(int j:graph[i]){
                adj.get(i).add(j);
                rev.get(j).add(i);
            }
            if(graph[i].length==0) {
                q.offerLast(i);
            }
        }

        while(!q.isEmpty()){
            int node=q.pollFirst();
            ans.add(node);

            for(int i:rev.get(node)){
                adj.get(i).remove(Integer.valueOf(node));
                if(adj.get(i).size()==0) q.offerLast(i);
            }
        }
        List<Integer> res=new ArrayList<>(ans);
        Collections.sort(res);
        return res;
    }
}