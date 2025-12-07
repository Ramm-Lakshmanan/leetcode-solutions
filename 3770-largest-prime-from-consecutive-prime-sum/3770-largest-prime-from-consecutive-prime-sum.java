class Solution {
    public int largestPrime(int n) {
        int[] primes=new int[500000+1];
        Arrays.fill(primes,1);
        primes[0]=0;
        primes[1]=0;
        for(int i=2;i<=Math.sqrt(500000);i++){
            if(primes[i]==1){
                for(int j=(i*i);j<=500000;j+=i){
                    primes[j]=0;
                }
            }
        }
        int sum=0,max=0;
        for(int i=0;i<=500000;i++){
            if(primes[i]==1){
                sum+=i;
                if(sum>n) break;
                if(primes[sum]==1) max=sum;
            }
        }
        return max;
    }
}