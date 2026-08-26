class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int len=Integer.MAX_VALUE;
        int[] cnt=new int[2];

        int left=0,right=0,n=s.length();
        StringBuilder sb=new StringBuilder();
        String ans="";

        while(right<n){
            cnt[s.charAt(right)-'0']++;
            sb.append(s.charAt(right));

            while(cnt[1]>k){
                cnt[s.charAt(left)-'0']--;
                left++;
                sb.deleteCharAt(0);
            }

            while(cnt[1]==k) {
                if(ans=="" || right-left+1<len){
                    ans=sb.toString();
                    len=right-left+1;
                }
                else if(right-left+1==len && sb.toString().compareTo(ans)<0){
                    ans=sb.toString();
                }

                cnt[s.charAt(left)-'0']--;
                left++;
                sb.deleteCharAt(0);
            }

            right++;
        }

        return ans;
    }
}