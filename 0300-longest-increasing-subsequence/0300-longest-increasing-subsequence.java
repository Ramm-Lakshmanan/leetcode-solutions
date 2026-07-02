class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] lis=new int[n];
        lis[0]=nums[0];
        int size=1;

        for(int i=1;i<n;i++){
            if(nums[i]>lis[size-1]){
                lis[size++]=nums[i];
            }
            else{
                int left=0,right=size-1;
                int idx=0;
                while(left<=right){
                    int mid=left+(right-left)/2;

                    if(lis[mid]<nums[i]){
                        left=mid+1;
                    }
                    else{
                        idx=mid;
                        right=mid-1;
                    }
                }
                lis[idx]=nums[i];
            }
        }
        return size;
    }
}