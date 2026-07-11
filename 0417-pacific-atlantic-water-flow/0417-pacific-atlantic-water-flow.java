class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length,n=heights[0].length;

        boolean[][] vis1=new boolean[m][n];
        boolean[][] vis2=new boolean[m][n];

        Deque<int[]> pac=new ArrayDeque<>();
        Deque<int[]> atl=new ArrayDeque<>();

        for(int i=0;i<m;i++){
            pac.offer(new int[]{i,0});
            atl.offer(new int[]{i,n-1});

            vis1[i][0]=true;
            vis2[i][n-1]=true;
        }

        for(int i=0;i<n;i++){
            pac.offer(new int[]{0,i});
            atl.offer(new int[]{m-1,i});

            vis1[0][i]=true;
            vis2[m-1][i]=true;
        }

        while(!pac.isEmpty()){
            int[] cur=pac.poll();
            int i=cur[0],j=cur[1];

            if(i>0 && !vis1[i-1][j] && heights[i-1][j]>=heights[i][j]){
                pac.offer(new int[]{i-1,j});
                vis1[i-1][j]=true;
            }
            if(j>0 && !vis1[i][j-1] && heights[i][j-1]>=heights[i][j]){
                pac.offer(new int[]{i,j-1});
                vis1[i][j-1]=true;
            }
            if(i<m-1 && !vis1[i+1][j] &&  heights[i+1][j]>=heights[i][j]){
                pac.offer(new int[]{i+1,j});
                vis1[i+1][j]=true;
            }
            if(j<n-1 && !vis1[i][j+1] &&  heights[i][j+1]>=heights[i][j]){
                pac.offer(new int[]{i,j+1});
                vis1[i][j+1]=true;
            }
        }
        
        while(!atl.isEmpty()){
            int[] cur=atl.poll();
            int i=cur[0],j=cur[1];

            if(i>0 && !vis2[i-1][j] && heights[i-1][j]>=heights[i][j]){
                atl.offer(new int[]{i-1,j});
                vis2[i-1][j]=true;
            }
            if(j>0 && !vis2[i][j-1] &&  heights[i][j-1]>=heights[i][j]){
                atl.offer(new int[]{i,j-1});
                vis2[i][j-1]=true;
            }
            if(i<m-1 && !vis2[i+1][j] &&  heights[i+1][j]>=heights[i][j]){
                atl.offer(new int[]{i+1,j});
                vis2[i+1][j]=true;
            }
            if(j<n-1 && !vis2[i][j+1] &&  heights[i][j+1]>=heights[i][j]){
                atl.offer(new int[]{i,j+1});
                vis2[i][j+1]=true;
            }
        }

        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis1[i][j] && vis2[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }
}