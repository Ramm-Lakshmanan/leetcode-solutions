class Solution {
    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
        int min=Integer.MAX_VALUE;

        int land=lst.length,water=wst.length;

        for(int i=0;i<land;i++){
            for(int j=0;j<water;j++){
                //Land then water
                int lf=lst[i]+ld[i];
                int tf1=Math.max(lf,wst[j])+wd[j];

                //Water then land
                int wf=wst[j]+wd[j];
                int tf2=Math.max(wf,lst[i])+ld[i];

                min=Math.min(min,Math.min(tf1,tf2));
            }
        }  
        return min;        
    }
}