class Solution {
    long mod=1000000007;
    
    public long power(int num,long pow){
        long base=(long)num;
        long res=1;
        while(pow>0){
            if(pow%2!=0){
                res=(res*base)%mod;
            }
            base=(base*base)%mod;
            pow/=2;
        }
        return res;
    }
    public int countGoodNumbers(long n) {
        long odd=(n+1L)/2L;
        long even=(n/2L);

        long oans=power(5,odd);
        long eans=power(4,even);

        return (int)((oans*eans)%mod);
    }
}