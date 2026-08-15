class Solution {
    public int longestSubsequence(int[] nums) {
        int zcnt=0;
        int xor=0;
        for(int ele:nums){
            xor^=ele;
            if(ele==0) zcnt++;
        }

        if(zcnt==nums.length) return 0;
        
        return xor==0?nums.length-1:nums.length;
    }
}