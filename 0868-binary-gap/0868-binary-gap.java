class Solution {
    public int binaryGap(int n) {
        String s=Integer.toBinaryString(n);
        int max=0;
        int i=0;
        while(i<s.length() && s.charAt(i)!='1') i++;
        int start=i;
        i++;
        while(i<s.length()){
            if(s.charAt(i)=='1'){
                max=Math.max(max,i-start);
                start=i;
            }
            i++;
        }
        return max;
    }
}