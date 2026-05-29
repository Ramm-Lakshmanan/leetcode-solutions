class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        int[] pre_sum=new int[n];
        pre_sum[0]=arr[0];
        for(int i=1;i<n;i++){
            pre_sum[i]=pre_sum[i-1]+arr[i];
        }

        int ans=0;

        for(int i=0;i<n;i++){
            if(i%2==0) ans+=pre_sum[i];
            for(int j=1;j<=i;j+=2){
                ans+=(pre_sum[i]-pre_sum[i-j]);
            }
        }
        return ans;
    }
}