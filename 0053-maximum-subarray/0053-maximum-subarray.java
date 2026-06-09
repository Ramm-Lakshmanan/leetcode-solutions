class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int cur=0;

        for(int ele:nums){
            cur=Math.max(cur+ele,ele);
            max=Math.max(cur,max);
        }
        return max;
    }
}