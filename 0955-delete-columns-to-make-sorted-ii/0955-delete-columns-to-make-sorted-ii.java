class Solution {
    public int minDeletionSize(String[] strs) {
        int rows=strs.length;
        int cols=strs[0].length();
        int ans=0;
        boolean[] sorted=new boolean[rows];
        Arrays.fill(sorted,false);
        for(int col=0;col<cols;col++){
            boolean del=false;
            int row=0;
            while(row<rows-1){
                if(!sorted[row] && strs[row].charAt(col)>strs[row+1].charAt(col)){
                    del=true;
                    break;
                }
                row++;
            }
            if(del){
                ans++;
                continue;
            }
            for(int i=0;i<rows-1;i++){
                if(!sorted[i] && strs[i].charAt(col)<strs[i+1].charAt(col)) sorted[i]=true;
            }
        }
        return ans;
    }
}