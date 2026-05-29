class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans=new ArrayList<>();
        Map<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<words[0].length();i++){
            hm.put(words[0].charAt(i),hm.getOrDefault(words[0].charAt(i),0)+1);
        }

        for(int j=1;j<words.length;j++){
            Map<Character,Integer> res=new HashMap<>();
            for(int i=0;i<words[j].length();i++){
                if(hm.getOrDefault(words[j].charAt(i),0)>0){
                    res.put(words[j].charAt(i),res.getOrDefault(words[j].charAt(i),0)+1);
                    hm.put(words[j].charAt(i),hm.getOrDefault(words[j].charAt(i),0)-1);
                }
            }
            hm=res;
        }

        for(char c:hm.keySet()){
            for(int i=0;i<hm.get(c);i++){
                ans.add(Character.toString(c));
            }
        }
        return ans;
    }
}