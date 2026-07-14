class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int size=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                size++;
                if(size>1)
                    sb.append(s.charAt(i));
            }
            else{
                size--;

                if(size>0)
                    sb.append(s.charAt(i));
            }
        }        

        return sb.toString();
    }
}