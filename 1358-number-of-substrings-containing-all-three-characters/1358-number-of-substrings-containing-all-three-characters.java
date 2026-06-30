class Solution {
    public int numberOfSubstrings(String s) {
        int ans=0;
        int left=0,right=0,n=s.length();
        int[] alph=new int[3];

        while(right<n){
            alph[s.charAt(right)-97]++;

            while(left<right && alph[0]>0 && alph[1]>0 && alph[2]>0){
                ans+=(n-right);
                alph[s.charAt(left)-97]--;
                left++;
            }
            right++;
        }
        return ans;
    }
}