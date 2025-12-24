class Solution {
    public long maximumScore(int[] nums, String s) {
        int n=nums.length;
        PriorityQueue<Long> pq=new PriorityQueue<>((a,b)->{
            return Long.compare(b,a);
        });
        long res=0L;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                if(!pq.isEmpty() && pq.peek()>(long)nums[i]) {
                    res+=pq.poll();
                    pq.offer((long)nums[i]);
                }
                else res+=nums[i];
            }
            else pq.offer((long)nums[i]);
        }
        return res;
    }
}