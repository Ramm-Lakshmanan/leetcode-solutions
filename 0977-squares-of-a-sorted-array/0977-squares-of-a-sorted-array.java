class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int pos=n-1;

        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                pos=i;
                break;
            }
        }

        int left=pos-1,right=pos;
        int[] ans=new int[n];
        int k=0;

        while(left>=0 && right<n){
            int l=nums[left]*nums[left];
            int r=nums[right]*nums[right];

            if(l<r){
                ans[k++]=l;
                left--;
            }
            else{
                ans[k++]=r;
                right++;
            }
        }

        while(left>=0){
            ans[k++]=nums[left]*nums[left];
            left--;
        }
        while(right<n){
            ans[k++]=nums[right]*nums[right];
            right++;
        }

        return ans;
    }
}