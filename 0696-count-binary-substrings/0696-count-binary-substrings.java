class Solution {
    public int countBinarySubstrings(String s) {
        int n=s.length();
        int i=0;
        int first=1;
        while(i<n-1 && s.charAt(i)==s.charAt(i+1)){
            first++;
            i++;
        }
        i++;
        int ans=0;
        while(i<n){
            int second=1;
            while(i<n-1 && s.charAt(i)==s.charAt(i+1)){
                second++;
                i++;
            }
            ans+=Math.min(first,second);
            first=second;
            i++;
        }
        return ans;
    }
}