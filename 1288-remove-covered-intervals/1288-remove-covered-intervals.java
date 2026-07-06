class Solution {
    public int removeCoveredIntervals(int[][] inter) {
        int n=inter.length;
        Arrays.sort(inter,(a,b)->{
            if(a[0]==b[0]) return Integer.compare(b[1],a[1]);
            return Integer.compare(a[0],b[0]);
        });
        int cnt=0;
        for(int i=1;i<n;i++){
            if(inter[i-1][0]<=inter[i][0] && inter[i][1]<=inter[i-1][1]){
                inter[i][0]=inter[i-1][0];
                inter[i][1]=inter[i-1][1];
                cnt++;
            }
        }
        return (n-cnt);
    }
}