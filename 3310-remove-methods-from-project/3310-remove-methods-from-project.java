class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] e) {
       List<List<Integer>> adj=new ArrayList<>();
       for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] edge:e){
            adj.get(edge[0]).add(edge[1]);
        }

        Deque<Integer> stk=new ArrayDeque<>();
        stk.push(k);
        boolean[] vis=new boolean[n];

        while(!stk.isEmpty()){
            int node=stk.pop();
            vis[node]=true;

            for(int next:adj.get(node)){
                if(!vis[next]) stk.push(next);
            }
        }

        boolean flag=true;
        for(int[] edge:e){
            if(!vis[edge[0]] && vis[edge[1]]){
                flag=false;
                break;
            }
        }

        List<Integer> ans=new ArrayList<>();

        if(!flag){
            for(int i=0;i<n;i++) ans.add(i);
            return ans;
        }
        else{
            for(int i=0;i<n;i++){
                if(!vis[i]) ans.add(i);
            }
            return ans;
        }
    }
}