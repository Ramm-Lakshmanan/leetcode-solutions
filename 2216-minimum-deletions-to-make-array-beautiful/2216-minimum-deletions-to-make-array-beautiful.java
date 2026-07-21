class Solution {
    public int minDeletion(int[] nums) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        ans.add(nums[0]);

        for(int i=1;i<n;i++){
            if(ans.size()%2!=0 && ans.get(ans.size()-1)==nums[i]) continue;
            else ans.add(nums[i]);
        }

        int rem=n-ans.size();
        if(ans.size()%2!=0) rem++;

        return rem;
    }
}