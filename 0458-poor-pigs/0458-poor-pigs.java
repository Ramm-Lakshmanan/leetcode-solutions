class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if(buckets==1) return 0;
        int rounds=(minutesToTest/minutesToDie)+1;
        int ans=rounds;
        int cnt=1;
        while(ans<buckets) {
            cnt++;
            ans*=rounds;
        }
        return cnt;
    }
}