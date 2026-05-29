class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans=new ArrayList<>();
        Map<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<words[0].length();i++){
            hm.put(words[0].charAt(i),hm.getOrDefault(words[0].charAt(i),0)+1);
        }

        for(int j=1;j<words.length;j++){
            Map<Character,Integer> hm1=new HashMap<>();
            for(int i=0;i<words[j].length();i++){
                hm1.put(words[j].charAt(i),hm1.getOrDefault(words[j].charAt(i),0)+1);
            }

            for(char c:hm.keySet()){
                if(!hm1.containsKey(c)){
                    hm.put(c,0);
                }
                else{
                    hm.put(c,Math.min(hm1.get(c),hm.get(c)));
                }
            }
        }

        for(char c:hm.keySet()){
            for(int i=0;i<hm.get(c);i++){
                ans.add(Character.toString(c));
            }
        }
        return ans;
    }
}