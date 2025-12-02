class Solution {
    public int titleToNumber(String columnTitle) {
        int ans=0;
        int j=0;
        for(int i=columnTitle.length()-1;i>=0;i--){
            ans+=(columnTitle.charAt(i)-'A'+1)*(Math.pow(26,j++));
        }
        return ans;
    }
}