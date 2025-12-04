class Solution {
    public int pref(char c){
        // L=0,R=2,S=1
        if(c=='L') return 0;
        else if(c=='S') return 1;
        else return 2;
    }
    public int countCollisions(String directions) {
        int ans=0;
        Deque<Character> stk=new ArrayDeque<>();
        for(int i=0;i<directions.length();i++){
            char x=directions.charAt(i);
            int pre=pref(x);
            if(stk.isEmpty() || (pref(stk.peekLast()) <= pre)){
                stk.offerLast(x);
            }
            else{
                while(!stk.isEmpty() && (pref(stk.peekLast())>pre)){
                    ans+=pref(stk.pollLast())-pre;
                    pre=1;
                }
                stk.offerLast('S');
            }
        }
        return ans;
    }
}