class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max=-1,n=nums.length;
        int[] min=new int[n];

        for(int i=n-1;i>=0;i--){
            min[i]=nums[i];
            if(i<n-1) min[i]=Math.min(min[i],min[i+1]);
        }

        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            if(max-min[i]<=k) return i;
        }
        return -1;
    }
}