class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0,left=0,right=0,n=s.length();

        Set<Character> set=new HashSet<>();

        while(right<n){
            while(left<right && set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}