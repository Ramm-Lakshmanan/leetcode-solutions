class Solution {
    public boolean isPalindrome(String s) {
        
        s=s.toLowerCase();
        StringBuilder nn=new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))) nn.append(s.charAt(i));
        }
        int n=nn.length();
        for(int i=0;i<n/2;i++){
            if(nn.charAt(i)!=nn.charAt(n-i-1)) return false;
        }
        return true;
    }
}