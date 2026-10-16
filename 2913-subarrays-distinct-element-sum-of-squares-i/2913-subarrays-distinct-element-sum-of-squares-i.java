class Solution {
    public int sumCounts(List<Integer> nums) {
        Set<Integer> set=new HashSet<>();
        int n=nums.size();
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                set.add(nums.get(j));
                ans+=(set.size()*set.size());
            }
            set.clear();
        }
        return ans;
    }
}