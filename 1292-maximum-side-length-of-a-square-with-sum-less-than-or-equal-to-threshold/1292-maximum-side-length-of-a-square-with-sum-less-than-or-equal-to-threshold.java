class Solution {
    public long func(int i,int j,int k,long[][] pref){
        long sum=0L;
        for(int x=i;x<=i+k;x++){
            if(j==0)
                sum+=(pref[x][j+k]);
            else{
                sum+=(pref[x][j+k]-pref[x][j-1]);
            }
        }
        return sum;
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;

        long[][] pref=new long[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0) pref[i][j]=(long)mat[i][j];
                else pref[i][j]=pref[i][j-1]+(long)mat[i][j];
            }
        }

        int max=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int req=Math.min(m-1-i,n-1-j);
                int low=0,high=req;
                while(low<=high){
                    int mid=(low+high)/2;
                    long comp=func(i,j,mid,pref);

                    if(comp<=(long)threshold){
                        max=Math.max(max,mid+1);
                        low=mid+1;
                    }
                    else{
                        high=mid-1;
                    }
                }
            }
        }
        return max;
    }
}