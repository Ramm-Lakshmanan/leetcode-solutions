class Solution {
    public void gameOfLife(int[][] board) {
        int[][] d={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        int m=board.length,n=board[0].length;
        List<List<Integer>> lives=new ArrayList<>();
        List<List<Integer>> dies=new ArrayList<>();

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
                    if(live<2){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(i);temp.add(j);
                        dies.add(temp);
                    }
                    else if(live>=2 && live<=3) continue;
                    else{
                        List<Integer> temp=new ArrayList<>();
                        temp.add(i);temp.add(j);
                        dies.add(temp);
                    }
                }
                else{
                    if(live==3){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(i);temp.add(j);
                        lives.add(temp);
                    }
                }
            }
        }

        for(List<Integer> newl:lives){
            board[newl.get(0)][newl.get(1)]=1;
        }

        for(List<Integer> newd:dies){
            board[newd.get(0)][newd.get(1)]=0;
        }
    }
}