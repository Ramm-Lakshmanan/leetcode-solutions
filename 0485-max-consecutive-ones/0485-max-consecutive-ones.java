class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int cur=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(cur>max) max=cur;
                cur=0;
            }
            else cur++;
        }
        return Math.max(max,cur);
    }
}