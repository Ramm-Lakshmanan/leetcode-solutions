class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];

        int left=0,right=n-1;
        int k=n-1;
        while(left<=right){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                ans[k--]=nums[left]*nums[left];
                left++;
            }
            else{
                ans[k--]=nums[right]*nums[right];
                right--;; 
            }
        }

        return ans;
    }
}