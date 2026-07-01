class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        if(n==0) return arr;

        int[] ans=new int[n];
        
        int[][] pq=new int[n][2];

        for(int i=0;i<n;i++){
            pq[i][0]=arr[i];
            pq[i][1]=i;
        }

        Arrays.sort(pq,(a,b)->Integer.compare(a[0],b[0]));
        int rank=1;
        ans[pq[0][1]]=rank;
        int prev=pq[0][0];

        for(int i=1;i<n;i++){
            if(prev!=pq[i][0]){
                rank++;
                prev=pq[i][0];
            }
            ans[pq[i][1]]=rank;
        }
        return ans;
    }
}