class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        int left=0,right=0,n=nums.length;
        int cnt=0;

        while(right<n){
            if(nums[right]==0) cnt++;

            while(cnt>k){
                if(nums[left]==0) cnt--;
                left++;
            }

            max=Math.max(max,right-left+1);
            right++;
        }

        return max;
    }
}