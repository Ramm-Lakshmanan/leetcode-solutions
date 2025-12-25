class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        Arrays.sort(happiness);
        long sum=0L;
        for(int i=n-1;i>=n-k;i--){
            if((long)happiness[i]-((long)n-1L-(long)i)>0L)
                sum+=(long)happiness[i]-((long)n-1L-(long)i);
        }
        return sum;
    }
}