class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> dq=new ArrayDeque<>();
        int n=nums.length;

        int left=0,right=0,i=0; 
        int[] ans=new int[n-k+1];
        while(right<n){
            while(!dq.isEmpty() && dq.peekLast()[0]<nums[right]){
                dq.pollLast();
            }
            dq.offer(new int[]{nums[right],right});

            if(right-left+1==k){
                while(right-dq.peek()[1]+1>k){
                    dq.poll();
                }
                ans[i++]=dq.peek()[0];
                left++;
            }
            right++;
        }
        return ans;
    }
}