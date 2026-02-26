class Solution {
    public int numSteps(String s) {
        int ans=0;
        StringBuilder sb=new StringBuilder(s);
        int n=sb.length()-1;
        while(n>=0){
            if(n==0 && sb.charAt(n)=='1') return ans;
            if(sb.charAt(n)=='0'){
                ans++;
                n--;
            }
            else{
                ans++;
                while(n>=0 && sb.charAt(n)=='1'){
                    ans++;
                    n--;
                }
                if(n>=0)sb.setCharAt(n,'1');
            }
        }
        return ans;
    }
}