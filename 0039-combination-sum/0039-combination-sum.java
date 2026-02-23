class Solution {
    public void func(int[] candidates,int idx,int sum,int target,List<Integer> curr,Set<List<Integer>> ans){
        
        if(idx==-1 || sum>target) return;

        List<Integer> temp_curr=new ArrayList<>();
        temp_curr.addAll(curr);
        int temp_sum=sum;
        for(int i=0;i<(target-sum)/candidates[idx];i++){
            temp_curr.add(candidates[idx]);
            temp_sum+=candidates[idx];
            if(temp_sum==target){
                ans.add(temp_curr);
            }
            func(candidates,idx-1,temp_sum,target,temp_curr,ans);
        }
        if(sum==target){
            ans.add(curr);
        }
        func(candidates,idx-1,sum,target,curr,ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> ans=new HashSet<>();
        int n=candidates.length;
        int idx=n-1,sum=0;
        List<Integer> curr=new ArrayList<>();
        func(candidates,idx,sum,target,curr,ans);
        return new ArrayList<>(ans);
    }
}