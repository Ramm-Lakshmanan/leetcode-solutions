class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int lmax=0,rmax=0;
        int ans=0;
        
        while(left<right){
            if(height[left]<height[right]){
                lmax=Math.max(lmax,height[left]);
                ans+=(lmax-height[left]);
                left++;
            }
            else{
                rmax=Math.max(rmax,height[right]);
                ans+=(rmax-height[right]);
                right--;
            }
        }

        return ans;
    }
}