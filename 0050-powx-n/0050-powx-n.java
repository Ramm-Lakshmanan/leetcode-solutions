class Solution {
    public double pow(double x,long n){
        if(n==1) return x;
        else if(n%2!=0){
            return x*Math.pow(pow(x,(n-1)/2),2);
        }
        else{
            return Math.pow(pow(x,n/2),2);
        }
    }
    public double myPow(double x, int n) {
        long m=(long)n;
        if(m<0L){
            m=Math.abs(m);
            x=1/x;
        }
        else if(m==0L) return (double)1;
        return pow(x,m);
    }
}