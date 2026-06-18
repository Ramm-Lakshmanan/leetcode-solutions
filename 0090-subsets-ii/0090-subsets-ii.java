class Solution {
    public void func(int idx,int[] nums,List<Integer> temp,Set<List<Integer>> ans){
        if(idx==-1){
            List<Integer> now=new ArrayList<>();
            now.addAll(temp);
            Collections.sort(now);
            ans.add(now);
            return;
        }
        
        temp.add(nums[idx]);
        func(idx-1,nums,temp,ans);
        temp.remove(temp.size()-1);
        func(idx-1,nums,temp,ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n=nums.length;
        Set<List<Integer>> ans=new HashSet<>();
        List<Integer> temp=new ArrayList<>();
        func(n-1,nums,temp,ans);
        List<List<Integer>> res=new ArrayList<>();
        res.addAll(ans);
        return res;
    }
}