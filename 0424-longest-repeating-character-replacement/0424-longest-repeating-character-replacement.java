class Solution {
    public int characterReplacement(String s, int k) {
        int[] alph=new int[26];
        int left=0;
        int right=0;
        int max=0;
        int res=0;
        while(right<s.length()){
            char c=s.charAt(right);
            alph[c-'A']++;
            max=Math.max(alph[c-'A'],max);
            while(right-left+1-max>k) {
                
                alph[s.charAt(left)-'A']--;
                left++;
                
            }
            res=Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}