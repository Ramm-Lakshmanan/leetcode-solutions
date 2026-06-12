class Solution {
    public void gameOfLife(int[][] board) {
        int[][] d={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        int m=board.length,n=board[0].length;
        int[][] next=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int dead=0,live=0;
                for(int k=0;k<8;k++){
                    int nx=i+d[k][0],ny=j+d[k][1];
                    if(nx>=0 && nx<m && ny>=0 && ny<n){
                        if(board[nx][ny]==0) dead++;
                        else live++;
                    }
                }
                if(board[i][j]==1){
                    if(live<2) next[i][j]=0;
                    else if(live>=2 && live<=3) next[i][j]=1;
                    else next[i][j]=0;
                }
                else{
                    if(live==3) next[i][j]=1;
                    else next[i][j]=0;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]=next[i][j];
            }
        }
    }
}