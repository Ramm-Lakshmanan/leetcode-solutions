class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        int ans=nums[low];
        while(low<high && nums[low]==nums[high]) low++;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
            }
        }

        return ans;
    }
}