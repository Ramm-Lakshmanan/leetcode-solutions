class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);int n=nums.length;
        int min=0;
        int mid=nums[n/2];

        for(int ele:nums){
            min+=Math.abs(ele-mid);
        }
        return min;
    }
}