class Solution {
    public boolean func(int idx,int sum1,int sum2,int[] nums,Boolean[][] dp){
        if(idx==-1){
            if(sum1==sum2) return true;
            else return false;
        }

        if(dp[idx][sum1]!=null) return dp[idx][sum1];

        boolean ch1=func(idx-1,sum1+nums[idx],sum2,nums,dp);
        boolean ch2=func(idx-1,sum1,sum2+nums[idx],nums,dp);

        return dp[idx][sum1]=ch1 || ch2;
    }
    public boolean canPartition(int[] nums) {
        int sum1=0,sum2=0,idx=nums.length-1;
        int sum=0;
        for(int i:nums) sum+=i;
        Boolean[][] dp=new Boolean[nums.length][sum+1];
        for(int i=0;i<nums.length;i++) Arrays.fill(dp[i],null);
        return func(idx,sum1,sum2,nums,dp);
    }
}