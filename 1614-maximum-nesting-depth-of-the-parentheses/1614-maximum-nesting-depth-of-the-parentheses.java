class Solution {
    public int maxDepth(String s) {
        int max=0;
        Deque<Character> stk=new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stk.push(s.charAt(i));
                max=Math.max(stk.size(),max);
            }
            else if(s.charAt(i)==')'){
                stk.pop();
            }
        }

        return max;
    }
}