class Solution {
    public void func(List<List<Integer>> ans,int idx,List<Integer> curr,int sum,int target,int[] candidates){
        if(sum==target){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(idx==candidates.length || sum>target) return;

        curr.add(candidates[idx]);
        func(ans,idx+1,curr,sum+candidates[idx],target,candidates);
        curr.remove(curr.size()-1);

        int next_idx=idx+1;
        while(next_idx<candidates.length && candidates[next_idx]==candidates[idx]) next_idx++;
        func(ans,next_idx,curr,sum,target,candidates);

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        func(ans,0,new ArrayList<>(),0,target,candidates);
        return ans;
    }
}