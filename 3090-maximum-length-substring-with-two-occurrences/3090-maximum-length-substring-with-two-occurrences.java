class Solution {
    public int maximumLengthSubstring(String s) {
        int[] hm=new int[26];

        int left=0,right=0;
        int max=0;
        while(right<s.length()){
            hm[s.charAt(right)-'a']++;

            while(hm[s.charAt(right)-'a']>2){
                hm[s.charAt(left)-'a']--;
                left++;
            }

            max=Math.max(max,right-left+1);
            right++;
        }

        return max;
    }
}