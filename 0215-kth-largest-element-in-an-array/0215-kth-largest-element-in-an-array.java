class Solution {
    // public int partition(int l,int r,int[] nums){
    //     int i=l-1;
    //     int pivot=nums[r];

    //     for(int j=l;j<r;j++){
    //         if(nums[j]>pivot){
    //             i++;
    //             int temp=nums[j];
    //             nums[j]=nums[i];
    //             nums[i]=temp;
    //         }
    //     }
    //     i++;
    //     int temp=nums[i];
    //     nums[i]=nums[r];
    //     nums[r]=temp;

    //     return i;
    // }
    // public void qsort(int l,int r,int[] nums,int k){
        
    //     if(l<=r){
    //         int q=partition(l,r,nums);

    //         if(q+1==k){
    //             return;
    //         }
    //         else if(q+1<k){
    //             qsort(q+1,r,nums,k);
    //         }
    //         else{
    //             qsort(l,q-1,nums,k);
    //         }
    //     }
    // }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int ele:nums) pq.offer(ele);
        while(k>1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}