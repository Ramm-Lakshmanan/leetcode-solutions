class Solution {
    public int minPairSum(int[] nums) {
        int n=nums.length;
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums) {
            pq1.offer(i);
            pq2.offer(i);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n/2;i++){
            ans=Math.max(ans,pq1.poll()+pq2.poll());
        }
        return ans;
    }
}