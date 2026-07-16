class Solution {
    public int[] asteroidCollision(int[] ast) {
        Deque<Integer> stk=new ArrayDeque<>();
        int i=0;
        int n=ast.length;
        while(i<n){
            int ele=ast[i];
            if(stk.isEmpty()) stk.push(ele);

            else if(stk.peek()>0 && ele<0){
                if(stk.peek()<=-ele) {
                    if(stk.peek()==-ele) i++;
                    stk.pop();
                    continue;
                }
            }
            else stk.push(ele);
            i++;
        }
        int[] ans=new int[stk.size()];

        int k=stk.size()-1;

        while(!stk.isEmpty()){
            ans[k--]=stk.pop();
        }

        return ans;
    }
}