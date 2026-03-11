class Solution {
    public void func(Set<List<Integer>> ans,List<Integer> curr,int idx,int[] nums){
        if(idx==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        ans.add(new ArrayList<>(curr));
        curr.add(nums[idx]);
        func(ans,curr,idx+1,nums);
        curr.remove(curr.size()-1);
        func(ans,curr,idx+1,nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans=new HashSet<>();
        func(ans,new ArrayList<>(),0,nums);
        return new ArrayList<>(ans);
    }
}