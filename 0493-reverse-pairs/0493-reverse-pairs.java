class Solution {
    public void merge(int low,int mid,int high,int[] arr){
        int left=low,right=mid+1;
        int[] temp=new int[high-low+1];
        int k=0;
        while(left<=mid && right<=high){
            if(arr[left]>arr[right]){
                temp[k++]=arr[right];
                right++;
            }
            else{
                temp[k++]=arr[left];
                left++;
            }
        }

        while(left<=mid){
            temp[k++]=arr[left];
            left++;
        }

        while(right<=high){
            temp[k++]=arr[right];
            right++;
        }

        for(int i=0;i<k;i++){
            arr[i+low]=temp[i];
        }
    }
    public int cnt_pairs(int low,int mid,int high,int[] arr){
        int left=low,right=mid+1;
        int ans=0;

        while(left<=mid && right<=high){
            if((long)arr[left]>2L*(long)arr[right]){
                ans+=(mid-left+1);
                right++;
            }
            else left++;
        }

        return ans;
    }
    public int msort(int low,int high,int[] nums){
        int c=0;
        if(low<high){
            int mid=low+(high-low)/2;
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