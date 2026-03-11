class Solution {
    public void func(List<List<Integer>> ans,List<Integer> curr,int idx,int[] nums){
        if(idx==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        func(ans,curr,idx+1,nums);
        curr.remove(curr.size()-1);
        
        int next_idx=idx+1;
        while(next_idx<nums.length && nums[next_idx]==nums[idx]) next_idx++;
        func(ans,curr,next_idx,nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        func(ans,new ArrayList<>(),0,nums);
        return ans;
    }
}