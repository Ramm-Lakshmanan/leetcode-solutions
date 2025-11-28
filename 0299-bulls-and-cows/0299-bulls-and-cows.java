class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0;
        StringBuilder sb1=new StringBuilder(secret);
        StringBuilder sb2=new StringBuilder(guess);
        Map<Character,Integer> hm=new HashMap<>();
        int i=0;
        int l=secret.length();
        while(i<l){
            if(sb1.charAt(i)==sb2.charAt(i)) {
                bulls++;
                sb1.deleteCharAt(i);
                sb2.deleteCharAt(i);
                l--;
                i--;
            }
            else
                hm.put(sb1.charAt(i),hm.getOrDefault(sb1.charAt(i),0)+1);
            i++;
        }
        int cows=0;
        for(int j=0;j<sb1.length();j++){
            if(hm.containsKey(sb2.charAt(j))){
                cows++;
                if(hm.get(sb2.charAt(j))==1){
                    hm.remove(sb2.charAt(j));
                }
                else{
                    hm.put(sb2.charAt(j),hm.get(sb2.charAt(j))-1);
                }
            }
        }
        return bulls+"A"+cows+"B";
    }
}