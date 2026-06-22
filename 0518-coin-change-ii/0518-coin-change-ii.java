class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int[] temp=new int[amount+1];
            for(int j=0;j<=amount;j++){
                temp[j]+=dp[j];
                if(j-coins[i-1]>=0) temp[j]+=temp[j-coins[i-1]];
            }
            dp=temp;
        }
        return dp[amount];
    }
}