class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hm=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            int[] alph=new int[26];

            for(int j=0;j<strs[i].length();j++){
                alph[strs[i].charAt(j)-97]++;
            }
            StringBuilder entry=new StringBuilder();
            
            for(int k=0;k<26;k++){
                if(alph[k]!=0){
                    String ele=Character.toString((k+97));
                    entry.append(ele).append(alph[k]);
                }
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