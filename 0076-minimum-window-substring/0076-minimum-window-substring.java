class Solution {
    /*public int check( Map<Character,Integer> hm){
        int ans=0;
        for(char c:hm.keySet()){
            if(hm.get(c)>0){
                ans=1;
                break;
            }
            else if(hm.get(c)<0){
                ans=-1;
            }
        }
        return ans;
    }*/
    public String minWindow(String s, String t) {
        if(s.equals(t)) return s;
        int m=s.length(),n=t.length();
        int req=0;
        Map<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++) hm.put(t.charAt(i),hm.getOrDefault(t.charAt(i),0)+1);

        int left=0,right=0,missing=t.length();
        int min=Integer.MAX_VALUE;
        String res="";

        while(right<m){
            char c=s.charAt(right);
            if(hm.getOrDefault(c,0)>0) missing--;

            hm.put(s.charAt(right),hm.getOrDefault(s.charAt(right),0)-1);

            while(missing==0){
                if(right-left+1<min){
                    min=right-left+1;
                    res=s.substring(left,right+1);
                }
                hm.put(s.charAt(left),hm.getOrDefault(s.charAt(left),0)+1);
                if(hm.getOrDefault(s.charAt(left),0)>0) missing++;
                left++;
            }
            right++;
        }
        return res;
    }
}