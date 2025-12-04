class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=n-1;i>0;i--){
            if(i==n-1) ans[i]=nums[i];
            else ans[i]=(ans[i+1]*nums[i]);
        }
        int prod=1;
        for(int i=0;i<n;i++){
            if(i!=n-1){
                ans[i]=prod*ans[i+1];
                prod*=nums[i];
            }
            else ans[i]=prod;
        }
        return ans;
    }
}