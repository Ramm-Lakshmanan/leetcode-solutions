class Solution {
    public void nextPermutation(int[] nums) {
        int idx=-1;
        int n=nums.length;

        for(int i=n-1;i>=1;i--){
            if(nums[i]>nums[i-1]){
                idx=i-1;
                break;
            }
        }
        if(idx==-1){
            for(int i=0;i<(n/2);i++){
                int temp=nums[i];
                nums[i]=nums[n-i-1];
                nums[n-i-1]=temp;
            }
            return ;
        }
        int req=Integer.MAX_VALUE;
        int idx2=-1;
        for(int i=idx+1;i<n;i++){
            if(nums[i]>nums[idx] && nums[i]<=req){
                idx2=i;
                req=nums[i];
            }
        }
        int temp=nums[idx];
        nums[idx]=nums[idx2];
        nums[idx2]=temp;

        int left=idx+1;
        int right=n-1;
        while(left<right){
            temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
        return;
    }
}