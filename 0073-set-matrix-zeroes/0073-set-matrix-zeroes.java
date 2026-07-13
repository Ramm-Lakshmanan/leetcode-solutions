class Solution {
    public void setZeroes(int[][] matrix) {
        int col=0,row=0;
        int m=matrix.length,n=matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    if(i==0 && j==0){
                        row=-1;col=-1;
                    }
                    else if(i==0){
                        matrix[0][j]=0;
                        row=-1;
                    }
                    else if(j==0){
                        matrix[i][0]=0;
                        col=-1;
                    }
                    else{
                        matrix[i][0]=0;
                        matrix[0][j]=0;
                    }
                }
            }
        }

        
        for(int i=1;i<m;i++){
            if(matrix[i][0]==0){
                for(int j=0;j<n;j++){
                    matrix[i][j]=0;
                }
            }
        }

        for(int j=1;j<n;j++){
            if(matrix[0][j]==0){
                for(int i=0;i<m;i++){
                    matrix[i][j]=0;
                }
            }
        }

        if(col==-1){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }

        if(row==-1){
            for(int i=0;i<n;i++){
                matrix[0][i]=0;
            }
        }
    }
}