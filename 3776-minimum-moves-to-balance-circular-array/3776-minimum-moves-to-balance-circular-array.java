class Solution {
    public long minMoves(int[] balance) {
        long sum = 0; int idx = -1;
        int n = balance.length;
        for(int i=0; i<n; i++){
            sum += balance[i];
            if(balance[i] < 0) idx = i;
        }
        if(sum < 0) return -1;
        if(idx == -1) return 0;
        long val=balance[idx];
        int left=(idx-1+n)%n,right=(idx+1)%n;
        long i=1L,ans=0L;
        while(val<0){
            if(balance[left]>0){
                long need=Math.min(balance[left],-val);
                val+=need;
                ans+=(need*i);
            }
            if(val<0 && balance[right]>0){
                long need=Math.min(-val,balance[right]);
                val+=need;
                ans+=(need*i);
            }
            i+=1L;
            left=(left-1+n)%n;
            right=(right+1)%n;
        }
        return ans;
    }
}