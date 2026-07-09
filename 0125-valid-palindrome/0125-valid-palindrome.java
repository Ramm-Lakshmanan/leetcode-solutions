class Solution {
    public boolean isPalindrome(String s) {
        
        s=s.toLowerCase();
        StringBuilder nn=new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i)) || (s.charAt(i)>='a' && s.charAt(i)<='z')) nn.append(s.charAt(i));
        }

        for(int i=0;i<nn.length()/2;i++){
            if(nn.charAt(i)!=nn.charAt(nn.length()-i-1)) return false;
        }
        return true;
    }
}