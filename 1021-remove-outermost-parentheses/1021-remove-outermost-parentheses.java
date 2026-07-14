class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();

        Deque<Character> stk=new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(stk.size()!=0)
                    sb.append(s.charAt(i));
                stk.push(s.charAt(i));
            }
            else{
                if(stk.size()>1){
                    sb.append(s.charAt(i));
                }
                stk.pop();
            }
        }        

        return sb.toString();
    }
}