class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;

        Map<Integer,Integer> hm=new HashMap<>();
        for(int cur:hand){
            hm.put(cur,hm.getOrDefault(cur,0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        int ans=0;

        for(int ele:hm.keySet()){
            pq.offer(new int[]{ele,hm.get(ele)});
        }

        while(!pq.isEmpty()){
            Map<Integer,Integer> temp=new HashMap<>();
            int[] prev=pq.poll();
            int p=prev[0];
            if(prev[1]>1){
                temp.put(prev[0],prev[1]-1);
            }
            for(int i=1;i<groupSize;i++){
                if(pq.isEmpty()) return false;
                int[] curr=pq.poll();
                if(curr[0]!=p+1) return false;
                if(curr[1]>1){
                    temp.put(curr[0],curr[1]-1);
                }
                p=curr[0];
            }

            for(int ele:temp.keySet()){
                pq.offer(new int[]{ele,temp.get(ele)});
            }
        }
        return true;
    }
}