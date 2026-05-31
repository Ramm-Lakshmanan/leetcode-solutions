class Solution {
    public boolean asteroidsDestroyed(int mass, int[] ast) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int ele:ast){
            pq.offer(ele);
        }
        long m=(long)mass;
        while(!pq.isEmpty()){
            int cur=pq.poll();
            if(m<(long)cur) return false;
            m+=(long)cur;
        }
        return true;
    }
}