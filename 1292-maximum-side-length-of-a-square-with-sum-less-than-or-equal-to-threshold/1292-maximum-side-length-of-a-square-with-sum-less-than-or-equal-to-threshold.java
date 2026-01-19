class Solution {
    public long func(int i, int j, int k, long[][] pref2) {
        int x2 = i + k, y2 = j + k;
        long sum = pref2[x2][y2];
        if (i > 0) sum -= pref2[i - 1][y2];
        if (j > 0) sum -= pref2[x2][j - 1];
        if (i > 0 && j > 0) sum += pref2[i - 1][j - 1];
        return sum;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;

        long[][] pref=new long[m][n];
        long[][] pref2=new long[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0) pref[i][j]=(long)mat[i][j];
                else pref[i][j]=pref[i][j-1]+(long)mat[i][j];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0) pref2[i][j]=pref[i][j];
                else pref2[i][j]=pref2[i-1][j]+pref[i][j];
            }
        }

        int max=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int req=Math.min(m-1-i,n-1-j);
                int low=0,high=req;
                while(low<=high){
                    int mid=(low+high)/2;
                    long comp=func(i,j,mid,pref2);

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