class Solution {
    public int ans(int n,int[] days,int[] costs,int[] dp){
        if(n==0) return Math.min(Math.min(costs[0],costs[1]),costs[2]);
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int ch1=costs[0]+ans(n-1,days,costs,dp);
        int ch2=Integer.MAX_VALUE,ch3=Integer.MAX_VALUE;
        if(days[n]-6<days[0]) ch2=costs[1];
        else{
            int search=Arrays.binarySearch(days,days[n]-6);
            if(search>=0) ch2=costs[1]+ans(search-1,days,costs,dp);
            else ch2=costs[1]+ans(Math.abs(search+2),days,costs,dp);
        }
        if(days[n]-29<days[0]) ch3=costs[2];
        else{
            int search=Arrays.binarySearch(days,days[n]-29);
            if(search>=0) ch3=costs[2]+ans(search-1,days,costs,dp);
            else ch3=costs[2]+ans(Math.abs(search+2),days,costs,dp);
        }
        return dp[n]=Math.min(Math.min(ch1,ch2),ch3);
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return ans(n-1,days,costs,dp);
    }
}