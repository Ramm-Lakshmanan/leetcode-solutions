class Solution {
    public void func(int[] nums){
        int n=nums.length;
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            for(int i=0;i<n/2;i++){
                int temp=nums[i];
                nums[i]=nums[n-i-1];
                nums[n-i-1]=temp;
            }
            return;
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[idx]){
                int temp=nums[i];
                nums[i]=nums[idx];
                nums[idx]=temp;
                break;
            }
        }
        int left=idx+1,right=n-1;

        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
    public String getPermutation(int n, int k) {
        int[] nums=new int[n];
        for(int i=1;i<=n;i++){
            nums[i-1]=i;
        }
        for(int i=1;i<k;i++){
            func(nums);
        }
        String ans="";
        for(int ele:nums) ans+=Integer.toString(ele);
        return ans;
    }
}