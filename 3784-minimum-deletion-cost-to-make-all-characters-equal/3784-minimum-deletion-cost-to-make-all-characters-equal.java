class Solution {
    public long minCost(String s, int[] cost) {
        int n=cost.length;
        long[] req=new long[26];
        long tot=0L;
        for(int i=0;i<n;i++){
            tot+=(long)cost[i];
            req[s.charAt(i)-'a']+=(long)cost[i];
        }
        long min=Long.MAX_VALUE;
        for(int i=0;i<26;i++){
            min=Math.min(min,tot-req[i]);
        }
        return min;
    }
}