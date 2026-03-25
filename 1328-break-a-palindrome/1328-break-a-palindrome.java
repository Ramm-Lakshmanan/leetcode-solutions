class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1) return "";
        int n=palindrome.length();
        StringBuilder sb=new StringBuilder(palindrome);
        boolean flag=false;
        for(int i=0;i<n;i++){
            if(i!=n/2 && palindrome.charAt(i)!='a'){
                sb.setCharAt(i,'a');
                flag=true;
                break;
            }
        }
        if(!flag) sb.setCharAt(n-1,'b');
        return sb.toString();
    }
}