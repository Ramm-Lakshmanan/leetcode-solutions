class pair{
    String string;
    int freq;
    public pair(String string,int freq){
        this.string=string;
        this.freq=freq;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> hm=new HashMap<>();
        for(String s:words){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            if(a.freq==b.freq) return (a.string).compareTo(b.string);
            return Integer.compare(b.freq,a.freq);
        });
        for(String s:hm.keySet()) pq.offer(new pair(s,hm.get(s)));
        
        List<String> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(pq.poll().string);
        }
        return ans;
    }
}