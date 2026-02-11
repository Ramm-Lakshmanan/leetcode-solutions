class Solution {
    public void func(List<List<Integer>> ans,List<Integer> curr,int node,int[][] graph){
        

        for(int i=0;i<graph[node].length;i++){
            List<Integer> temp=new ArrayList<>();
            temp.addAll(curr);
            temp.add(graph[node][i]);
            if(graph[node][i]==graph.length-1) ans.add(temp);
            else
                func(ans,temp,graph[node][i],graph);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        curr.add(0);
        func(ans,curr,0,graph);
        return ans;
    }
}