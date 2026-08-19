class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> hm=new HashMap<>();

        int left=0,right=0;
        int max=0;
        while(right<s.length()){
            hm.put(s.charAt(right),hm.getOrDefault(s.charAt(right),0)+1);

            while(hm.get(s.charAt(right))>2){
                hm.put(s.charAt(left),hm.get(s.charAt(left))-1);
                left++;
            }

            max=Math.max(max,right-left+1);
            right++;
        }

        return max;
    }
}