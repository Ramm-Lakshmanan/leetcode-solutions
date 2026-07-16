class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int odd=0,ans=0,left=0,right=0,n=nums.length;

        while(right<n){
            if(nums[right]%2!=0) odd++;

            if(odd==k){
                right++;
                int leftsub=0,rightsub=0;

                while(nums[left]%2==0){
                    left++;
                    leftsub++;
                }

                while(right<n && nums[right]%2==0){
                    right++;
                    rightsub++;
                }

                ans+=((leftsub+1)*(rightsub+1));
                left++;
                odd--;
                continue;
            }

            right++;
        }

        return ans;
    }
}