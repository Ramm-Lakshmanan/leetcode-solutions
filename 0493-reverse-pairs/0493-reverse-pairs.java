class Solution {
    public void merge(int low,int mid,int high,int[] nums){
        int left=low,right=mid+1;
        int[] temp=new int[high-low+1];int k=0;

        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp[k++]=nums[left++];
            }
            else{
                temp[k++]=nums[right++];
            }
        }
        while(left<=mid){
            temp[k++]=nums[left++];
        }
        while(right<=high){
            temp[k++]=nums[right++];
        }

        for(int i=0;i<k;i++) nums[low+i]=temp[i];
    }
    public int cnt_pairs(int low,int mid,int high,int[] nums){
        int right=mid+1;
        int cnt=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)nums[i]>2L*(long)nums[right]){
                right++;
            }
            cnt+=right-(mid+1);
        }
        return cnt;
    }
    public int msort(int low,int high,int[] nums){
        int c=0;
        if(low<high){
            int mid=(low+high)/2;
            c+=msort(low,mid,nums);
            c+=msort(mid+1,high,nums);
            c+=cnt_pairs(low,mid,high,nums);
            merge(low,mid,high,nums);
        }
        return c;
    }
    public int reversePairs(int[] nums) {
        int n=nums.length;
        return msort(0,n-1,nums);
    }
}