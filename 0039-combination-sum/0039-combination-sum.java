class Solution {
    public void func(List<List<Integer>> ans,int idx,List<Integer> curr,int sum,int target,int[] candidates){
        if(sum==target && idx==candidates.length){
            ans.add(new ArrayList<>(curr));
        }
        if(idx>=candidates.length || sum>target) return;

        curr.add(candidates[idx]);
        func(ans,idx,curr,sum+candidates[idx],target,candidates);
        curr.remove(curr.size()-1);
        func(ans,idx+1,curr,sum,target,candidates);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        func(ans,0,new ArrayList<>(),0,target,candidates);
        return ans;
    }
}