class Solution {
    public int maxDepth(String s) {
        int max=0,len=0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                len++;
                max=Math.max(max,len);
            }
            else if(s.charAt(i)==')'){
                len--;
            }
        }

        return max;
    }
}