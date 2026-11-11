class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1=(long)cost1;
        long c2=(long)cost2;
        long c12=(long)costBoth;
        long n1=(long)need1;
        long n2=(long)need2;

        long ans=(n1*c1)+(n2*c2);
        ans=Math.min(ans,Math.max(n1,n2)*c12);
        ans=(n1<n2)?Math.min(ans,(Math.min(n1,n2)*c12)+Math.abs(n1-n2)*c2):Math.min(ans,(Math.min(n1,n2)*c12)+Math.abs(n1-n2)*c1);

        return ans;
    }
}