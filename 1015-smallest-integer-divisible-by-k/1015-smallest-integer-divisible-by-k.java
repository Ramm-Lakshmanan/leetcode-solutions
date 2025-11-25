class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0 || k%5==0) return -1;
        else{
            int ans=1;
            int len=1;
            while(ans%k!=0){
                ans=((ans*10)+1)%k;
                len++;
            }
            return len;
        }
    }
}