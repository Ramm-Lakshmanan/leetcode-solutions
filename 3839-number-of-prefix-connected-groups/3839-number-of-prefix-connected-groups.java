class Solution {
    public int prefixConnected(String[] words, int k) {
        Map<String,Integer> hm=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(words[i].length()<k) continue;
            hm.put(words[i].substring(0,k),hm.getOrDefault(words[i].substring(0,k),0)+1);
        }
        int ans=0;
        for(String s:hm.keySet()){
            if(hm.get(s)>=2) ans++;
        }
        return ans;
    }
}