class Solution {
    public String largestEven(String s) {
        int idx=s.length()-1;
        while(idx>=0 && s.charAt(idx)=='1') idx--;
        return s.substring(0,idx+1);
    }
}