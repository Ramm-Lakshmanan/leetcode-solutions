class Solution {
    public int sum(String s){
        int tot=0;
        for(char c:s.toCharArray()){
            tot+=(c-'0');
        }
        return tot;
    }
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i+=k){
                sb.append(sum(s.substring(i,Math.min(i+k,s.length()))));
            }
            s=sb.toString();
        }
        return s;
    }
}