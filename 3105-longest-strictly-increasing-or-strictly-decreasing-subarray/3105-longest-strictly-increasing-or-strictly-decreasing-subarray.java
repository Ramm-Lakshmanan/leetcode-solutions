class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max=1;
        int n=nums.length;
        int i=0;

        while(i<n){
            if(i<n-1 && nums[i]<nums[i+1]){
                int len=1;
                while(i<n-1 && nums[i]<nums[i+1]){
                    i++;len++;
                }
                max=Math.max(max,len);
            }
            else if(i<n-1 && nums[i]>nums[i+1]){
                int len=1;
                while(i<n-1 && nums[i]>nums[i+1]){
                    i++;len++;
                }
                max=Math.max(max,len);
            }
            else i++;
        } 
        return max;      
    }
}