class Solution {
    public boolean free(int[] n_queens,int row,int col){
        for(int i=0;i<n_queens.length;i++){
            if(n_queens[i]!=-1){
                if(Math.abs(col-i)==Math.abs(row-n_queens[i])) return false;
            }
        }
        return true;
    }
    public void func(int row,int[] n_queens,int n,List<List<String>> ans,List<String> template){
        if(row==n){
            List<String> temp=new ArrayList<>();
            temp.addAll(template);
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder(temp.get(n_queens[i]));
                sb.setCharAt(i,'Q');
                temp.set(n_queens[i],sb.toString());
            }
            ans.add(temp);
            return;
        }

        for(int col=0;col<n;col++){
            if(n_queens[col]==-1 && free(n_queens,row,col)){
                n_queens[col]=row;
                func(row+1,n_queens,n,ans,template);
                n_queens[col]=-1;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        if(n==2 || n==3) {
            return new ArrayList<>();
        }
        else if(n==1){
            List<String> res=new ArrayList<>();
            res.add("Q");
            List<List<String>> ans=new ArrayList<>();
            ans.add(res);
            return ans;
        }
        else{
            List<List<String>> ans=new ArrayList<>();
            List<String> template=new ArrayList<>();
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append('.');
            }
            for(int i=0;i<n;i++){
                template.add(sb.toString());
            }
            int[] n_queens=new int[n];
            Arrays.fill(n_queens,-1);
            func(0,n_queens,n,ans,template);
            return ans;
        }
    }
}