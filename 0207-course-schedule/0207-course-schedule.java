class Solution {
    public boolean dfs(int node,boolean[] visited,boolean[] inStack,List<List<Integer>> adj_list){
        inStack[node]=true;

        for(int neigh:adj_list.get(node)){
            if(!visited[neigh]){
                if(inStack[neigh]) return false;

                if(!dfs(neigh,visited,inStack,adj_list)) return false;
            }
        }
        visited[node]=true;
        inStack[node]=false;
        return true;
    }
    public boolean canFinish(int v, int[][] e) {
        List<List<Integer>> adj_list=new ArrayList<>();
        for(int i=0;i<v;i++) adj_list.add(new ArrayList<>());

        for(int i=0;i<e.length;i++){
            adj_list.get(e[i][1]).add(e[i][0]);
        }

        boolean[] visited=new boolean[v];
        boolean[] inStack=new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(!dfs(i,visited,inStack,adj_list)) return false;
            }
        }
        return true;
    }
}