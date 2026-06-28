class pair{
    char c;
    int freq;
    public pair(char c,int freq){
        this.c=c;
        this.freq=freq;
    }
}
class Solution {
    public String frequencySort(String s) {
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
            pair curr=pq.poll();
            for(int i=0;i<curr.freq;i++) sb.append(curr.c);
        }
        return sb.toString();
    }
}