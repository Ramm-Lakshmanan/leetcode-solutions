class Solution {
    public int countPartitions(int[] nums) {
        int tot=0;
        for(int i:nums) tot+=i;
        int ans=0;
        int cur=0;
        for(int i=0;i<nums.length-1;i++){
            cur+=nums[i];
            if((cur%2==0 && (tot-cur)%2==0)||((cur%2!=0 && (tot-cur)%2!=0))) ans++;
        }
        return ans;
    }
}