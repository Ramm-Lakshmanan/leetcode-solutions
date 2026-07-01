class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        if(n==0) return arr;

        int[] ans=new int[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            pq.offer(new int[]{arr[i],i});
        }

        int rank=1;
        int[] prev=pq.poll();
        ans[prev[1]]=rank;

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            if(curr[0]!=prev[0]){
                rank++;
            }
            ans[curr[1]]=rank;
            prev=curr;
        }
        return ans;
    }
}