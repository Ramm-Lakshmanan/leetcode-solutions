class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length;
        long[] prefix_0=new long[n];
        long[] prefix_1=new long[n];
        long org=(long)prices[0]*(long)strategy[0];

        if(strategy[0]==-1) prefix_0[0]=(long)prices[0];
        else if(strategy[0]==1) prefix_0[0]=-(long)prices[0];

        if(strategy[0]==-1) prefix_1[0]=(long)prices[0]*2L;
        else if(strategy[0]==0) prefix_1[0]=(long)prices[0];

        for(int i=1;i<n;i++){
            org=org+(long)prices[i]*(long)strategy[i];

            if(strategy[i]==-1) prefix_0[i]=prefix_0[i-1]+(long)prices[i];
            else if(strategy[i]==1) prefix_0[i]=prefix_0[i-1]-(long)prices[i];
            else prefix_0[i]=prefix_0[i-1];

            if(strategy[i]==-1) prefix_1[i]=prefix_1[i-1]+((long)prices[i]*2L);
            else if(strategy[i]==0) prefix_1[i]=prefix_1[i-1]+(long)prices[i];
            else prefix_1[i]=prefix_1[i-1];
        }

        long max=org;

        for(int i=0;i<n-k+1;i++){
            long cur=org;
            if(i==0){
                cur+=prefix_0[i+(k/2)-1]+prefix_1[i+k-1]-prefix_1[i+(k/2)-1];
            }
            else{
                cur+=prefix_0[i+(k/2)-1]-prefix_0[i-1]+prefix_1[i+k-1]-prefix_1[i+(k/2)-1];
            }
            max=Math.max(max,cur);
        }

        return max;
    }
}