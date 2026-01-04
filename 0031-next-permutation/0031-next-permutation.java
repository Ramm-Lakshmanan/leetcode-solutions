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
        
        for(int i=n-1;i>idx;i--){
            if(nums[i]>nums[idx]){
                int temp=nums[idx];
                nums[idx]=nums[i];
                nums[i]=temp;
                break;
            }
        }
        int left=idx+1;
        int right=n-1;
        while(left<right){
            int temp2=nums[left];
            nums[left]=nums[right];
            nums[right]=temp2;
            left++;
            right--;
        }
        return;
    }
}