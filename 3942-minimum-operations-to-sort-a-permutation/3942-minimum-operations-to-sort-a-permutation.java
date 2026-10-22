class Solution {
    public int minOperations(int[] nums) {
        int cnt=0,n=nums.length;
        if(n==1) return 0;

        int idx=0;
        for(int i=1;i<n;i++){
            if(Math.abs(nums[i-1]-nums[i])>=2) {
                idx=i;
                cnt++;
            }
        }
        if(Math.abs(nums[0]-nums[n-1])>=2) cnt++;

        if(cnt>1) return -1;
        else if(idx==0){
            if(nums[idx]==0) return 0;
            else return 1;
        }
        else{
            if(nums[idx-1]<nums[idx]) return 1+Math.min(idx,n-idx);
            return Math.min(idx,n-idx+2);
        }
    }
}