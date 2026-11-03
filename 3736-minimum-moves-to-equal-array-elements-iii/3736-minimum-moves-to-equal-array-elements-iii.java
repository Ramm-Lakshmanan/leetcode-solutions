class Solution {
    public int minMoves(int[] nums) {
        int max=0;
        for(int ele:nums) max=Math.max(max,ele);
        int ans=0;
        for(int ele:nums) ans+=(max-ele);

        return ans;
    }
}