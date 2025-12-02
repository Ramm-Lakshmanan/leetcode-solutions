class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        List<Integer> ans=new ArrayList<>();
        int i;
        while(left<=right && top<=bottom){
            i=left;
            while(i<=right){
                ans.add(matrix[top][i]);
                i++;
            }
            top++;

            i=top;
            while(i<=bottom){
                ans.add(matrix[i][right]);
                i++;
            }
            right--;

            if(top<=bottom){
                i=right;
                while(i>=left){
                    ans.add(matrix[bottom][i]);
                    i--;
                }
                bottom--;
            }

            if(left<=right){
                i=bottom;
                while(i>=top){
                    ans.add(matrix[i][left]);
                    i--;
                }
                left++;
            }
        }
        return ans;
    }
}