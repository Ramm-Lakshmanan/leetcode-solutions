class Solution {
    public int[][] generateMatrix(int n) {
        int top=0,bottom=n-1,left=0,right=n-1;
        int num=1;
        int  i;
        int[][] ans=new int[n][n];
        while(top<=bottom && left<=right){
            i=left;
            while(i<=right){
                ans[top][i]=num;
                i++;
                num++;
            }
            top++;

            i=top;
            while(i<=bottom){
                ans[i][right]=num;
                num++;
                i++;
            }
            right--;

            if(top<=bottom){
                i=right;
                while(i>=left){
                    ans[bottom][i]=num;
                    num++;
                    i--;
                }
                bottom--;
            }
            

            if(left<=right){
                i=bottom;
                while(i>=top){
                    ans[i][left]=num;
                    num++;
                    i--;
                }
                left++;
            }
            
        }
        return ans;
    }
}