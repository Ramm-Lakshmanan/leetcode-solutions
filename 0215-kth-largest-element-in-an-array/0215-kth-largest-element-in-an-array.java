class Solution {
    public int partition(int l,int r,int[] nums){
        int i=l-1;
        int pivot=nums[r];

        for(int j=l;j<r;j++){
            if(nums[j]>pivot){
                i++;
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }
        }
        i++;
        int temp=nums[i];
        nums[i]=nums[r];
        nums[r]=temp;

        return i;
    }
    public int qsort(int l,int r,int[] nums,int k){
        
        while(l<=r){
            int q=partition(l,r,nums);

            if(q+1==k){
                return nums[q];
            }
            else if(q+1<k){
                l=q+1;
            }
            else{
                r=q-1;
            }
        }
        return nums[k-1];
    }
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        return qsort(0,n-1,nums,k);
    }
}