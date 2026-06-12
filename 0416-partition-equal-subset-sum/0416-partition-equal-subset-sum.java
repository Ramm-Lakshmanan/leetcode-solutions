class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        for(int ele:nums) sum+=ele;

        if(sum%2!=0) return false;

        boolean[] dp=new boolean[(sum/2)+1];
        
        for(int i=0;i<=n;i++) dp[0]=true;

        for(int i=1;i<=n;i++){
            boolean[] temp=new boolean[(sum/2)+1];
            for(int j=1;j<=(sum/2);j++){
                if(nums[i-1]>j) temp[j]=dp[j];
                else temp[j]=dp[j] | dp[j-nums[i-1]];
            }
            dp=temp;
        }
        return dp[(sum/2)];
    }
}