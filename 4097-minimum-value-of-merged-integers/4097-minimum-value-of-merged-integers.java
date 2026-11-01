class Solution {
    public int minMergedInteger(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i+=2){
            StringBuilder sb=new StringBuilder();
            sb.append(nums[i]);
            sb.append(nums[i+1]);
            min=Math.min(min,Integer.parseInt(sb.toString()));
        }
        return min;
    }
}