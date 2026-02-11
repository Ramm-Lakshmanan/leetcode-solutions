class Solution {
    public void func(List<String> res,int co,int cc,int n,String curr){
        if(co==n && cc==n){
            res.add(curr);
            return;
        }
        if(co>n || cc>n) return;

        String temp1=curr;
        temp1+="(";
        func(res,co+1,cc,n,temp1);
        if(co>0 && cc<co){
            String temp2=curr;
            temp2+=")";
            func(res,co,cc+1,n,temp2);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        func(res,0,0,n,"");
        return res;
    }
}