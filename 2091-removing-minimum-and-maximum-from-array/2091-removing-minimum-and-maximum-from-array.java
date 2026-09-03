class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int idx1=-1,idx2=-1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
                idx1=i;
            }
            if(nums[i]>max){
                max=nums[i];
                idx2=i;
            }
        }
        int ans=Math.max(idx1,idx2)+1;
        ans=Math.min(ans,n-Math.min(idx1,idx2));
        ans=Math.min(ans,idx1+1+(n-idx2));
        ans=Math.min(ans,idx2+1+(n-idx1));

        return ans;
    }
}