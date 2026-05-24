class Solution {
    public void dfs(int[][] image,int sr,int sc,int og,int color){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length) return;

        if(image[sr][sc]==og){
            image[sr][sc]=color;
            dfs(image,sr+1,sc,og,color);
            dfs(image,sr-1,sc,og,color);
            dfs(image,sr,sc-1,og,color);
            dfs(image,sr,sc+1,og,color);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int og=image[sr][sc];
        if(og==color) return image;
        
        dfs(image,sr,sc,og,color);
        return image;
    }
}