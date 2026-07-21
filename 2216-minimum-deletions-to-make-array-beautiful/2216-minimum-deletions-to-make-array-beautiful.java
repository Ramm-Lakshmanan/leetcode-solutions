class Solution {
    public int minDeletion(int[] nums) {
        int n=nums.length;
        int prev=nums[0];
        int cnt=1;

        for(int i=1;i<n;i++){
            if(cnt%2!=0 && prev==nums[i]) continue;
            else{
                cnt++;
                prev=nums[i];
            }
        }

        int rem=n-cnt;
        if(cnt%2!=0) rem++;

        return rem;
    }
}