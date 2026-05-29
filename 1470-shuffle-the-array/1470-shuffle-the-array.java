class Solution {
    public int[] shuffle(int[] nums, int n) {
        int left=0,right=n;
        int[] ans=new int[2*n];
        int k=0;

        while(k<2*n){
            if(k%2==0) ans[k++]=nums[left++];
            else ans[k++]=nums[right++];
        }
        return ans;
    }
}