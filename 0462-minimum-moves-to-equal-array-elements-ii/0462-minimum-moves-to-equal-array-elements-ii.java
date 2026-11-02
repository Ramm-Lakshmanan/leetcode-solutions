class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);int n=nums.length;
        long[] pre=new long[n];
        for(int i=0;i<n;i++){
            pre[i]=(long)nums[i];
            if(i>0){
                pre[i]+=pre[i-1];
            }
        }
        long min=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(i==0){
                long cur=Math.abs(((long)(n-1)*(long)nums[0])- (pre[n-1]-pre[0]));
                min=Math.min(min,cur);
            }
            else if(i==n-1){
                long cur=Math.abs(((long)(n-1)*(long)nums[n-1])- (pre[n-1]-nums[n-1]));
                min=Math.min(min,cur);
            }
            else{
                long cur_l=Math.abs(((long)i * (long)nums[i]) - (pre[i]-nums[i]));
                long cur_r=Math.abs(((long)(n-i-1) * (long)nums[i]) - (pre[n-1]-pre[i]));
                min=Math.min(min,cur_l+cur_r);
            }
        }
        return (int)min;
    }
}