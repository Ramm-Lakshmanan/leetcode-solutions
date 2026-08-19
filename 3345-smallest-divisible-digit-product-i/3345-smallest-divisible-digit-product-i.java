class Solution {
    public boolean check(int n,int t){
        int prod=1;
        while(n>0){
            int dig=n%10;
            prod*=dig;
            n=n/10;
        }
        
        return (prod%t==0)?true:false;
    }
    public int smallestNumber(int n, int t) {
        while(!check(n,t)){
            n++;
        }
        return n;
    }
}