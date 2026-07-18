class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        int low=0,high=nums.length-1;

        while(high>=0){
            if(nums[high]>b) high--;
            else break;
        }

        while(low<nums.length && nums[low]<a) low++;

        int mid=low;
        int cnt=0;
        
        long ans=0,mod=1000000007;
        
        while((mid-cnt)<=high){
            if(nums[mid]<a){
                ans=(ans+(mid-cnt-low+mod)%mod);
                low++;mid++;
            }
            else if(nums[mid]>b){
                ans=(ans+(high-mid+mod)%mod);
                mid++;
                high--;
                cnt++;
            }
            else mid++;
        }

        return (int)(ans%mod);
    }
}