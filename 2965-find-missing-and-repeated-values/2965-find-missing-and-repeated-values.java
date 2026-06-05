class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int asum=0,csum=0;
        int assum=0,cssum=0;
        int n=grid.length;
        for(int i=1;i<=(n*n);i++){
            asum+=i;
            assum+=(i*i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                csum+=grid[i][j];
                cssum+=(grid[i][j]*grid[i][j]);
            }
        }
        int eq1=csum-asum;
        int eq2=cssum-assum;
        int req=eq2/eq1;

        int a=(eq1+req)/2;
        int b=req-a;

        return new int[]{a,b}; 
    }
}