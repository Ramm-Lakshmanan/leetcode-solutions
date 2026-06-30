class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(nums[0]>=n-1) return true;

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int targ=n-1;
        for(int i=0;i<n;i++){
            if(nums[i]>=(targ-i)) pq.offer(i);
        }

        int k=nums[0];   
        int i=1;
        while(k>0  && i<n){
            k--;
            while(!pq.isEmpty() && i>pq.peek()) pq.poll();
            if(pq.isEmpty()) return false;

            if(nums[i]>=pq.peek()-i) return true;
            k=Math.max(k,nums[i]);
            i++;
        }   
        return false;  
    }
}