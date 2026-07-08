class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hm=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            Map<Character,Integer> req=new TreeMap<>();
            for(int j=0;j<strs[i].length();j++){
                req.put(strs[i].charAt(j),req.getOrDefault(strs[i].charAt(j),0)+1);
            }
            StringBuilder entry=new StringBuilder();
            for(char c:req.keySet()){
                entry.append(Character.toString(c)+Integer.toString(req.get(c)));
            }

            if(hm.containsKey(entry.toString())){
                List<String> temp=hm.get(entry.toString());
                temp.add(strs[i]);
            }
            else{
                List<String> temp=new ArrayList<>();
                temp.add(strs[i]);
                hm.put(entry.toString(),temp);
            }
        }

        List<List<String>> ans=new ArrayList<>();

        for(String s:hm.keySet()){
            ans.add(hm.get(s));
        }

        return ans;
    }
}