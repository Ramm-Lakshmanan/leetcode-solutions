class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0,n=nums.length,sum=0;
        int len=Integer.MAX_VALUE;

        while(right<n){
            sum+=nums[right];
            while(sum>=target && left<=right){
                len=Math.min(len,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }

        if(len==Integer.MAX_VALUE) return 0;
        return len;
    }
}