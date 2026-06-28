class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int ele:nums){
            hm.put(ele,hm.getOrDefault(ele,0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        for(int ele:hm.keySet()){
            pq.offer(new int[]{ele,hm.get(ele)});
            if(pq.size()>k) pq.poll();
        }
        int[] ans=new int[k];
        int ptr=k-1;
        while(!pq.isEmpty()){
            ans[ptr--]=pq.poll()[0];
        }
        return ans;
    }
}