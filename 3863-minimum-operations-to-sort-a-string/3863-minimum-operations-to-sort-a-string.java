class Solution {
    public int minOperations(String s) {
        int n=s.length();
        boolean flag=true;
        char min=s.charAt(0);
        int min_idx=0;
        char max=s.charAt(0);
        int max_idx=0;
        for(int i=1;i<n;i++){
            if(s.charAt(i-1)>s.charAt(i)){
                flag=false;
            }
            if(s.charAt(i)<min) {
                min=s.charAt(i);
                min_idx=i;
            }
            if(s.charAt(i)>=max){
                max=s.charAt(i);
                max_idx=i;
            }
        } 
        if(flag) return 0;
        else if(min_idx==0 || max_idx==n-1) return 1;
        else if(min!=max && min_idx==n-1 && max_idx==0){
            if(n==2) return -1;
            else return 3;
        }
        else return 2;
    }
}