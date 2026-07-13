class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stk=new ArrayDeque<>();

        int i=0,n=s.length();

        while(i<n){
            while(i<n && !stk.isEmpty() && stk.peek().equals(s.charAt(i))){
                stk.pop();
                i++;
            }
            if(i<n)
                stk.push(s.charAt(i));
            i++;
        }
        StringBuilder ans=new StringBuilder();
        while(!stk.isEmpty()) ans.append(stk.pop());

        ans.reverse();

        return ans.toString();
    }
}