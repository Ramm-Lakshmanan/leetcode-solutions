class Solution {
    public String minWindow(String s, String t) {
        int m=s.length(),n=t.length();
        if(m<n) return "";

        Map<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(t.charAt(i),hm.getOrDefault(t.charAt(i),0)+1);
        }

        int rem=n,left=0,right=0;
        int[] ans=new int[2];
        int min=Integer.MAX_VALUE;

        while(right<m){
            if(hm.containsKey(s.charAt(right))){
                int occr=hm.get(s.charAt(right));
                if(occr>0) rem--;
                hm.put(s.charAt(right),occr-1);
            }

            while(rem==0){
                if(right-left+1<min){
                    ans[0]=left;ans[1]=right;
                    min=right-left+1;
                }

                if(!hm.containsKey(s.charAt(left))){
                    left++;
                }
                else{
                    int occr=hm.get(s.charAt(left));
                    if(occr==0) rem++;
                    hm.put(s.charAt(left),occr+1);
                    left++;
                }
            }

            right++;
        }

        return min==Integer.MAX_VALUE?"":s.substring(ans[0],ans[1]+1);
    }
}