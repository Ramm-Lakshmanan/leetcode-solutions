class Solution {
    public boolean isSafe(int row,int col,int[] n_queens){
        for(int c=0;c<n_queens.length;c++){
            if(n_queens[c]!=-1){
                if(Math.abs(c-col)==Math.abs(n_queens[c]-row)) return false;
            }
        }
        return true;
    }
    public int func(int row,int n,int[] n_queens){
        if(row==n) return 1;
        int cnt=0;
        for(int col=0;col<n;col++){
            if(n_queens[col]==-1 && isSafe(row,col,n_queens)){
                n_queens[col]=row;
                cnt+=func(row+1,n,n_queens);
                n_queens[col]=-1;
            }
        }
        return cnt;
    }
    public int totalNQueens(int n) {
        if(n==1) return 1;
        int[] n_queens=new int[n];
        Arrays.fill(n_queens,-1);
        int row=0;
        return func(row,n,n_queens);
    }
}