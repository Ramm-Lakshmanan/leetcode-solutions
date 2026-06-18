class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);Arrays.sort(s);
        int j=0;
        int ans=0;
        for(int greed:g){
            while(j<s.length){
                if(greed<=s[j]){
                    ans++;
                    break;
                }
                else{
                    j++;
                }
            }
            j++;
        }
        return ans;
    }
}