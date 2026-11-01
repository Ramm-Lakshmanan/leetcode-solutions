class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int i=1;i<nums.length;i++){
            ans+=nums[i]-nums[0];
        }
        return ans;
    }
}