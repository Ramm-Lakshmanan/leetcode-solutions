class Solution {
    public boolean func(int row,int col,int idx,String word,char[][] board,boolean[][] visited){
        if(idx==word.length()) return true;
        if(row==board.length || col==board[0].length) return false;
        if(board[row][col]!=word.charAt(idx)) {
            if(idx==0){
                if(col==board[0].length-1){
                    return func(row+1,0,idx,word,board,visited);
                }
                else{
                    return func(row,col+1,idx,word,board,visited);
                }
            }
            else return false;
        }
        
        if(idx==word.length()-1) return true;
        visited[row][col]=true;
        boolean res=false;
        if(!res && col!=board[0].length-1 && !visited[row][col+1]){
            res=func(row,col+1,idx+1,word,board,visited);
        }
        if(!res && row!=board.length-1 && !visited[row+1][col]){
            res=func(row+1,col,idx+1,word,board,visited);
        }
        if(!res && col!=0 && !visited[row][col-1]){
            res=func(row,col-1,idx+1,word,board,visited);
        }
        if(!res && row!=0 && !visited[row-1][col]){
            res=func(row-1,col,idx+1,word,board,visited);
        }
        if(!res)visited[row][col]=false;
        if(!res && idx==0){
            if(col==board[0].length-1){
                return func(row+1,0,idx,word,board,visited);
            }
            else{
                return func(row,col+1,idx,word,board,visited);
            }
        }
        return res;
}
    public boolean exist(char[][] board, String word) {
        int row=board.length,col=board[0].length;
        boolean[][] visited=new boolean[row][col];
        for(int i=0;i<row;i++) Arrays.fill(visited[i],false);
        return func(0,0,0,word,board,visited);
    }
}