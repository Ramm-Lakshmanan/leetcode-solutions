class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len=tasks.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        Map<Character,Integer> hm=new HashMap<>();

        for(int i=0;i<len;i++){
            hm.put(tasks[i],hm.getOrDefault(tasks[i],0)+1);
        }

        for(char c:hm.keySet()){
            pq.offer(hm.get(c));
        }
        int ans=0;
        while(!pq.isEmpty()){
            List<Integer> queue=new ArrayList<>();
            int i=0;
            while(i<=n){
                if(pq.isEmpty()) break;
                else{
                    int curr=pq.poll();
                    curr--;
                    if(curr>0){
                        queue.add(curr);
                    }
                    ans++;
                }
                i++;
            }
            for(int ele:queue) pq.offer(ele);
            if(!pq.isEmpty()){
                ans+=(n-i+1);
            }
        }
        return ans;
    }
}