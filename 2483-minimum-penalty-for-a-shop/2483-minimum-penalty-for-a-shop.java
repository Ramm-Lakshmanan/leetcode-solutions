class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length(),cy=0;
        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='Y') cy++;
        }
        int cn=0;
        int idx=0;
        int penality=cy;
        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='Y') cy--;
            else cn++;
            if(cy+cn<penality) {
                penality=cy+cn;
                idx=i+1;
            }
        }
        return idx;
    }
}