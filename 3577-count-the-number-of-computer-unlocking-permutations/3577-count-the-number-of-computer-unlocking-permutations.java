class Solution {
    public int countPermutations(int[] complexity) {
        int n=complexity.length;
        System.out.println(n-1);
        long res=1,mod=1000000007;
        int min=complexity[0];
        int cnt=0;
        for(int i:complexity){
            if(i<min) return 0;
            if(i==min) cnt++;
        }
        
        if(cnt>1) return 0;
        for(int i=1;i<=n-1;i++){
            res=(res*i)%mod;
        }
        return (int)(res);
    }
}