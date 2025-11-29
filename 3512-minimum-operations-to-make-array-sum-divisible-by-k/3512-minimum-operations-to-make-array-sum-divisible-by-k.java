class Solution {
    public int minOperations(int[] nums, int k) {
        int sum=0;
        for(int i:nums) sum=(sum+i)%k;
        
        return sum;
    }
}