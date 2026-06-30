class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(nums[0]>=n-1) return true;
        int targ=n-1;
        int k=nums[0];   
        int i=1;
        while(k>0  && i<n){
            k--;

            if(nums[i]>=targ-i) return true;
            k=Math.max(k,nums[i]);
            i++;
        }   
        return false;  
    }
}