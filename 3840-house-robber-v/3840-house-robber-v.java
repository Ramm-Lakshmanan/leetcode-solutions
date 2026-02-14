class Solution {
    public long func(int[] nums,int[] colors,int idx,long[] dp){
        if(idx==-1) return 0L;
        if(idx==0) return (long)nums[0];

        if(dp[idx]!=-1L) return dp[idx];
        long ch1=Long.MIN_VALUE,ch2=Long.MIN_VALUE,ch3=Long.MIN_VALUE;
        if(colors[idx]!=colors[idx-1]) ch1=(long)nums[idx]+func(nums,colors,idx-1,dp);
        else{
            ch2=(long)nums[idx]+func(nums,colors,idx-2,dp);
            ch3=(long)func(nums,colors,idx-1,dp);
        }
        return dp[idx]=Math.max(ch1,Math.max(ch2,ch3));
    }
    public long rob(int[] nums, int[] colors) {
        int n=nums.length;
        long[] dp=new long[n];
        Arrays.fill(dp,-1L);
        return func(nums,colors,n-1,dp);
    }
}