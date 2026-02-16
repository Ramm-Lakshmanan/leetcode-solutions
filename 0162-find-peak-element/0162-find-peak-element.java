class Solution {
    public int findPeakElement(int[] nums) {

        int n=nums.length;
        if(n==1) return 0;

        int low=0,high=n-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(mid==0){
                if(nums[mid]>nums[mid+1]) return mid;
                else low=mid+1;
            }
            else if(mid==n-1){
                if(nums[mid]>nums[mid-1]) return mid;
                else high=mid-1;
            }
            else{
                int mid_l=mid-1;
                int mid_g=mid+1;

                if(nums[mid]>nums[mid_l] && nums[mid]>nums[mid_g]) return mid;
                else if(nums[mid_g]>nums[mid]) low=mid+1;
                else  high=mid-1;
            }
        }
        return 0;
    }
}