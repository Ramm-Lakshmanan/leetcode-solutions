class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long[] arr=new long[n];
        for(int i=0;i<n;i++) arr[i]=(long)Math.abs(nums[i]);

        Arrays.sort(arr);
        long sum=0;
        int left=0,right=n-1;

        while(left<right){
            sum+=(arr[right]*arr[right])-(arr[left]*arr[left]);
            left++;
            right--;
        }
        if(left==right) sum+=Math.pow(arr[left],2);
        return sum;
    }
}