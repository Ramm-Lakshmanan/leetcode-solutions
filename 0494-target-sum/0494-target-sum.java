class Solution {
    public int func(int idx,int cur,int target,int[] nums,int[][] dp,int sum){
        if(idx==-1){
            if(target==cur) return 1;
            return 0;
        }

        if(dp[idx][sum+cur]!=-1) return dp[idx][sum+cur];
        int c=0;
        c+=func(idx-1,cur-nums[idx],target,nums,dp,sum);
        c+=func(idx-1,cur+nums[idx],target,nums,dp,sum);
        return c;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length,sum=0;
        for(int ele:nums) sum+=ele;

        int[][] dp=new int[n][(2*sum)+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return func(n-1,0,target,nums,dp,sum);
    }
}