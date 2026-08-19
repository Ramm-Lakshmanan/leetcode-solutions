class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] e) {
       List<List<Integer>> adj=new ArrayList<>();
       for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] edge:e){
            adj.get(edge[0]).add(edge[1]);
        }

        Deque<Integer> stk=new ArrayDeque<>();
        stk.push(k);
        Set<Integer> vis=new HashSet<>();

        while(!stk.isEmpty()){
            int node=stk.pop();
            vis.add(node);

            for(int next:adj.get(node)){
                if(!vis.contains(next)) stk.push(next);
            }
        }

        boolean flag=true;
        for(int[] edge:e){
            if(!vis.contains(edge[0]) && vis.contains(edge[1])){
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
                if(!vis.contains(i)) ans.add(i);
            }
            return ans;
        }
    }
}