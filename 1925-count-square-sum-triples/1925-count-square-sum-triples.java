class Solution {
    static int[] sqrs=new int[250];
    static boolean built=false;

    static void square(){
        if(built) return ;

        for(int i=1;i<=250;i++) sqrs[i-1]=(i*i);
        built=true;
    }
    public int countTriples(int n) {
        square();

        int cnt=0;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                int sq=(i*i)+(j*j);
                if(sq<=(n*n) && Arrays.binarySearch(sqrs,sq)>=0) cnt+=2;
            }
        }
        return cnt;
    }
}