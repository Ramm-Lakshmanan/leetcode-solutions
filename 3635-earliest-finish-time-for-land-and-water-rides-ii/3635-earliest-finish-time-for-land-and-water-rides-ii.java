class Solution {
    public int earliestFinishTime(int[] la, int[] ld, int[] wa, int[] wd) {
        int m=la.length,n=wa.length;
        //Land First
        int l=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            l=Math.min(l,la[i]+ld[i]);
        }
        int minl=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minl=Math.min(minl,Math.max(l,wa[i])+wd[i]);
        }

        //Water First
        int w=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) w=Math.min(w,wa[i]+wd[i]);

        int mind=Integer.MAX_VALUE;
        for(int i=0;i<m;i++) mind=Math.min(mind,Math.max(w,la[i])+ld[i]);

        return Math.min(mind,minl);
    }
}
