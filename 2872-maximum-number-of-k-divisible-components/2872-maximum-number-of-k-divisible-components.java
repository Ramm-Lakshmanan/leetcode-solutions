class Solution {
    public int[] dfs(int[] visited,List<List<Integer>> adj,int res,int node,int[] values,int k){
        int sum=0;
        visited[node]=1;
        for(int i=0;i<adj.get(node).size();i++){
            if(visited[adj.get(node).get(i)]==0){
                int[] ans=dfs(visited,adj,res,adj.get(node).get(i),values,k);
                res=ans[0];
                sum+=(ans[1])%k;          
            }
        }
        sum+=values[node];
        if(sum%k==0) {
            res++;
        }
        return new int[]{res,sum};
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        int max=0;
        int[] visited=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        max=Math.max(max,dfs(visited,adj,0,0,values,k)[0]);
        return max;
    }
}