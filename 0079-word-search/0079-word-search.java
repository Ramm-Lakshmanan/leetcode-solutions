class Solution {
    public boolean func(int row,int col,int idx,String word,char[][] board,boolean[][] visited){
        if(idx==word.length()) return true;
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || visited[row][col]) return false;

        if(board[row][col]!=word.charAt(idx)) return false;
        visited[row][col]=true;
        boolean found= func(row-1,col,idx+1,word,board,visited)
                || func(row+1,col,idx+1,word,board,visited)
                || func(row,col-1,idx+1,word,board,visited)
                || func(row,col+1,idx+1,word,board,visited);
        visited[row][col]=false;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int r=board.length,c=board[0].length;
        boolean[][] visited=new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(func(i,j,0,word,board,visited)) return true;
            }
        }
        return false;
    }
}