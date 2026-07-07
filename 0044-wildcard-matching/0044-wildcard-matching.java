class Solution {
    public boolean func(int i,int j,String s,String p,Boolean[][] dp){
        if(i==-1 && j==-1)  return true;
        else if(j==-1) return false;
        else if(i==-1){
            for(int k=j;k>=0;k--){
                if(p.charAt(k)!='*') return false;
            }
            return true;
        }

        if(dp[i][j]!=null) return dp[i][j];

        if(p.charAt(j)=='?') return dp[i][j]=func(i-1,j-1,s,p,dp);
        else if(p.charAt(j)=='*'){
            return dp[i][j]=func(i,j-1,s,p,dp) || func(i-1,j,s,p,dp);
        }
        else return dp[i][j]=(s.charAt(i)==p.charAt(j)) && func(i-1,j-1,s,p,dp);
    }
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        Boolean[][] dp=new Boolean[n][m];
        return func(n-1,m-1,s,p,dp);
    }
}