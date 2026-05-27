class Solution {
    public int[] sortedSquares(int[] nums) {
        int p=-1,n=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                p=i;
                n=i-1;
                break;
            }
        }
        int[] ans=new int[nums.length];
        int k=0;
        while(k<nums.length){
            int neg=Integer.MAX_VALUE;
            int pos=Integer.MAX_VALUE;

            if(n>=0 && n<nums.length){
                neg=(int)Math.pow(nums[n],2);
            }
            if(p>=0 && p<nums.length){
                pos=(int)Math.pow(nums[p],2);
            }
            if(pos<=neg){
                ans[k++]=pos;
                p++;
            }
            else{
                ans[k++]=neg;
                n--;
            }
        }
        return ans;
    }
}