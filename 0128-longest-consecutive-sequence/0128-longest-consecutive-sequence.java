class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max=1,n=nums.length;
        if(n==0) return 0;
        int len=1;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1){
                len++;
            }
            else{
                if(nums[i]==nums[i-1]) continue;
                max=Math.max(max,len);
                len=1;
            }
        }
        max=Math.max(max,len);
        return max;
    }
}