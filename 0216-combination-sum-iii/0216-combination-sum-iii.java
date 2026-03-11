class Solution {
    public void func(List<List<Integer>> ans,int idx,List<Integer> curr,int sum,int target,int k,int[] nums){
        if(sum==target && curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size()>k || idx==nums.length || sum>target) return;
        
        curr.add(nums[idx]);
        func(ans,idx+1,curr,sum+nums[idx],target,k,nums);
        curr.remove(curr.size()-1);

        func(ans,idx+1,curr,sum,target,k,nums);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ans=new ArrayList<>();
        func(ans,0,new ArrayList<>(),0,n,k,nums);
        return ans;
    }
}