class Solution {
    static boolean built=false;
    static boolean[] primes=new boolean[20];
    static void sieve(){
        if(!built){
            Arrays.fill(primes,true);
            primes[0]=false;
            primes[1]=false;
            for(int i=0;i<=Math.sqrt(primes.length-1);i++){
                if(primes[i]){
                    for(int j=i*i;j<=primes.length-1;j+=i){
                        primes[j]=false;
                    }
                }
            }
            built=true;
        }
    }
    public static int countPrimeSetBits(int left, int right) {
        sieve();
        int ans=0;
        for(int i=left;i<=right;i++){
            if(primes[(Integer.bitCount(i))]) ans++;
        }
        return ans;
    }
}