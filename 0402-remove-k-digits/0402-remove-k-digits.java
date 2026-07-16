class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if(n==k) return "0";

        Deque<Integer> stk=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(stk.isEmpty()){
                if(num.charAt(i)!='0') stk.push(num.charAt(i)-'0');
            }
            else{
                int cur=num.charAt(i)-'0';
                while(!stk.isEmpty() && k>0 && stk.peek()>cur){
                    stk.pop();
                    k--;
                }
                if(!stk.isEmpty() || cur!=0) stk.push(cur);
            }
        }

        while(!stk.isEmpty() && k>0) {
            stk.pop();
            k--;
        }

        StringBuilder res=new StringBuilder();
        while(!stk.isEmpty()){
            res.append(stk.pop());
        }
        res.reverse();

        return res.isEmpty()?"0":res.toString();
    }
}