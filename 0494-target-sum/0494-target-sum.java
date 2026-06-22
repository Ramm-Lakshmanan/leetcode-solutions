class Solution {
    // public int func(int idx,int cur,int target,int[] nums,int[][] dp,int sum){
    //     if(idx==-1){
    //         if(target==cur) return 1;
    //         return 0;
    //     }

    //     if(dp[idx][sum+cur]!=-1) return dp[idx][sum+cur];
    //     int c=0;
    //     c+=func(idx-1,cur-nums[idx],target,nums,dp,sum);
    //     c+=func(idx-1,cur+nums[idx],target,nums,dp,sum);
    //     return dp[idx][sum+cur]=c;
    // }
    public int findTargetSumWays(int[] nums, int target) {
        
        // Some positive and some neg so p-n=target && p+n=sum
        // so p=(target+sum)/2;

        int n=nums.length,sum=0;
        for(int ele:nums) sum+=ele;

        target=Math.abs(target);

        if((sum+target)%2!=0) return 0;
        int targ=(sum+target)/2;

        int[][] dp=new int[n+1][targ+1];

        dp[0][0]=1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=targ;j++){
                dp[i][j]+=dp[i-1][j];
                if(nums[i-1]<=j) dp[i][j]+=dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][targ];
    }
}