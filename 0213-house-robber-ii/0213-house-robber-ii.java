class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int max=0;
        int prev1=nums[0],prev2=0,curr=-1;
        for(int i=1;i<n-1;i++){
            int ch1=prev1;
            int ch2=nums[i];
            if(i>=2) ch2+=prev2;
            curr=Math.max(ch1,ch2);
            prev2=prev1;
            prev1=curr;
        }
        max=prev1;

        if(n>1) prev1=nums[1];
        prev2=0;
        curr=-1;
        for(int i=2;i<n;i++){
            int ch1=prev1;
            int ch2=nums[i];
            if(i>=2) ch2+=prev2;
            curr=Math.max(ch1,ch2);
            prev2=prev1;
            prev1=curr;
        }
        return Math.max(max,prev1);
    }
}