class Solution {
    public int countTriples(int n) {
        int[] sqrs=new int[n];
        for(int i=1;i<=n;i++) sqrs[i-1]=(i*i);
        int cnt=0;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                int sq=(i*i)+(j*j);
                if(Arrays.binarySearch(sqrs,sq)>=0) cnt+=2;
            }
        }
        return cnt;
    }
}