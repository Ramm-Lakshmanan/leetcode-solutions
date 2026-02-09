class Solution {
    void func(List<List<Integer>> ans, List<Integer> curr,int[] nums,int idx){
        if(idx==nums.length) return;
        List<Integer> temp1=new ArrayList<>();
        for(int i=0;i<curr.size();i++) temp1.add(curr.get(i));
        temp1.add(nums[idx]);
        ans.add(temp1);
        func(ans,temp1,nums,idx+1);
        func(ans,curr,nums,idx+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(curr);
        func(ans,curr,nums,0);
        return ans;
    }
}