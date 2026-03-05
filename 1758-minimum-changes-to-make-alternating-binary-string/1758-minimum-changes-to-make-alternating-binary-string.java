class Solution {
    public int minOperations(String s) {
        int poss1=0,poss2=1;
        
        StringBuilder sb1=new StringBuilder(s);
        char prev1=sb1.charAt(0);
        for(int i=1;i<sb1.length();i++){
            if(sb1.charAt(i)==prev1){
                poss1++;
                if(prev1=='1') sb1.setCharAt(i,'0');
                else sb1.setCharAt(i,'1');
            }
            prev1=sb1.charAt(i);
        }

        StringBuilder sb2=new StringBuilder(s);
        char prev2=(sb2.charAt(0)=='0')?'1':'0';
        for(int i=1;i<sb2.length();i++){
            if(sb2.charAt(i)==prev2){
                poss2++;
                if(prev2=='1') sb2.setCharAt(i,'0');
                else sb2.setCharAt(i,'1');
            }
            prev2=sb2.charAt(i);
        }

        return Math.min(poss1,poss2);
    }
}