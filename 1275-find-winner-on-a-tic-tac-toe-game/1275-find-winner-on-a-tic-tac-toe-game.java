class Solution {
    public String tictactoe(int[][] moves) {
        int[][] board=new int[3][3];
        for(int i=0;i<moves.length;i++){
            if(i%2==0){
                board[moves[i][0]][moves[i][1]]=1;
            }
            else{
                board[moves[i][0]][moves[i][1]]=-1;
            }
        }

        // Row & Column Check

        for(int i=0;i<3;i++){
            if(board[i][0]==board[i][1] && board[i][1]==board[i][2]){
                if(board[i][0]==1) return "A";
                else if(board[i][0]==-1) return "B";
            }
            else if(board[0][i]==board[1][i] && board[1][i]==board[2][i]){
                if(board[0][i]==1) return "A";
                else if(board[0][i]==-1)return "B";
            }
        }

        if(board[0][0]==board[1][1] && board[1][1]==board[2][2]){
            if(board[0][0]==1) return "A";
            else if(board[0][0]==-1)return "B";
        }

        else if(board[0][2]==board[1][1] && board[1][1]==board[2][0]){
            if(board[1][1]==1) return "A";
            else if(board[1][1]==-1)return "B";
        }

        if(moves.length==9) return "Draw";
        return "Pending";

    }
}