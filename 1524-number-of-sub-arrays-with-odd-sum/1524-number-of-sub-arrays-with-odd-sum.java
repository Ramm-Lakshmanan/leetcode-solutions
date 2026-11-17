class Solution {
    public int numOfSubarrays(int[] arr) {
        int ans=0;
        int mod=1000000007;
        int sum=0,codd=0,ceven=0;

        for(int ele:arr){
            sum+=ele;
            if(sum%2==0) {
                ans=(ans+codd)%mod;
                ceven++;
            }
            else {
                ans=(ans+ceven)%mod;
                codd++;
            }
        }
        return (ans+codd)%mod;
    }
}