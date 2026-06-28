class pair{
    char c;
    int freq;
    public pair(char c,int freq){
        this.c=c;
        this.freq=freq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        Map<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));

        for(char c:hm.keySet()){
            pq.offer(new pair(c,hm.get(c)));
        }

        StringBuilder sb=new StringBuilder();

        while(!pq.isEmpty()){
            pair first=pq.poll();
            sb.append(first.c);
            if(!pq.isEmpty()){
                pair second=pq.poll();
                sb.append(second.c);

                if(first.freq>1) pq.offer(new pair(first.c,first.freq-1));
                if(second.freq>1) pq.offer(new pair(second.c,second.freq-1));
            }
            else{
                if(first.freq>1) pq.offer(new pair(first.c,first.freq-1));
                if(!pq.isEmpty()) return "";
            }     
        }
        return sb.toString();
    }
}