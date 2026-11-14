class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min=Integer.MAX_VALUE;
        int n=nums.size();
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                if(j-i+1>r) break;
                sum+=nums.get(j);
                if(j-i+1>=l && sum>0) min=Math.min(min,sum); 
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}