class Solution {
    public int sumFourDivisors(int[] nums) {
        int res=0;
        for(int i:nums){
            int temp=0;
            int cnt=0;
            for(int j=1;j<=Math.sqrt(i);j++){
                if(cnt>4) break;
                if(i%j==0){
                    cnt++;
                    temp+=j;
                    if((i/j)!=j){
                        cnt++;
                        temp+=(i/j);
                    }
                }
            }
            if(cnt==4) res+=temp;
        }
        return res;
    }
}