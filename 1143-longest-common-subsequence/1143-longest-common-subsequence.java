class Solution {
    // public int func(int i,int j,String text1,String text2,int[][] dp){
    //     if(i<0 || j<0) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     if(text1.charAt(i)==text2.charAt(j)){
    //         return dp[i][j]=1+func(i-1,j-1,text1,text2,dp);
    //     }
    //     int ch1=func(i-1,j,text1,text2,dp);
    //     int ch2=func(i,j-1,text1,text2,dp);
    //     int ch3=func(i-1,j-1,text1,text2,dp);

    //     return dp[i][j]=Math.max(ch1,Math.max(ch2,ch3));
    // }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(),m=text2.length();
        int[][] dp=new int[n][m];
        
        for(int i=0;i<n;i++){
            if(text1.charAt(i)==text2.charAt(0)) {
                dp[i][0]=1;
            }
            else if(i>0){
                dp[i][0]=dp[i-1][0];
            }
        }
        
        for(int i=0;i<m;i++){
            if(text1.charAt(0)==text2.charAt(i)) {
                dp[0][i]=1;
            }
            else if(i>0){
                dp[0][i]=dp[0][i-1];
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j-1],Math.max(dp[i][j-1],dp[i-1][j]));
                }
            }
        }
        return dp[n-1][m-1];
    }
}