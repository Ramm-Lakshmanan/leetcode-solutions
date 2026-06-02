class Solution {
    // public int func(int i,int j,String text1,String text2,int[][] dp){
    //     if(i<0 || j<0) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     if(text1.charAt(i)==text2.charAt(j)){
    //         return dp[i][j]=1+func(i-1,j-1,text1,text2,dp);
    //     }
    //     int ch1=func(i-1,j,text1,text2,dp);
    //     int ch2=func(i,j-1,text1,text2,dp);

    //     return dp[i][j]=Math.max(ch1,ch2);
    // }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(),m=text2.length();
        int[] dp=new int[m+1];
        for(int i=1;i<=n;i++){
            int[] temp=new int[m+1];
            int prev=0;
            for(int j=1;j<=m;j++){
                
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    temp[j]=1+dp[j-1];
                }
                else{
                    temp[j]=Math.max(prev,dp[j]);
                }
                prev=temp[j];
            }
            dp=temp;
        }
        return dp[m];
    }
}