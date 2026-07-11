class Solution {
    public boolean palindrome(int l,int r,String s){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n=s.length();

        for(int len=n-1;len>=0;len--){
            for(int start=0;start+len<n;start++){
                if(palindrome(start,start+len,s)) return s.substring(start,start+len+1);
            }
        }
        return "";
    }
}