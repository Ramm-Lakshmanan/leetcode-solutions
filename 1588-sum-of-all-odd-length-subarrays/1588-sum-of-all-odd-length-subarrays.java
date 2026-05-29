class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            int tot_subarrays=(i+1)*(n-i);
            int odd_subarrays=(tot_subarrays+1)/2;
            ans+=arr[i]*odd_subarrays;
        }
        return ans;
    }
}