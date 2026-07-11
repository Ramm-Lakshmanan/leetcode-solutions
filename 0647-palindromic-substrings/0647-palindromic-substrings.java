class Solution {
    int cnt=0;
    public void palindrome(int left,int right,String s){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            cnt++;
        }
    }
    public int countSubstrings(String s) {
        int n=s.length();

        for(int i=0;i<n;i++){
            palindrome(i,i,s);
            palindrome(i,i+1,s);
        }

        return cnt;
    }
}