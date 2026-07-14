class Solution {
    public int romanToInt(String s) {
        int n=s.length();
        Map<Character,Integer> hm=new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);

        int i=n-2;
        int ans=hm.get(s.charAt(n-1));
        while(i>=0){
            char c=s.charAt(i);

            if(c=='I'){
                if(s.charAt(i+1)=='V' || s.charAt(i+1)=='X') ans-=hm.get(c);
                else ans+=hm.get(c);
            }

            else if(c=='X'){
                if(s.charAt(i+1)=='L' || s.charAt(i+1)=='C') ans-=hm.get(c);
                else ans+=hm.get(c);
            }

            else if(c=='C'){
                if(s.charAt(i+1)=='D' || s.charAt(i+1)=='M') ans-=hm.get(c);
                else ans+=hm.get(c);
            }

            else{
                ans+=hm.get(c);
            }
            i--;
        }

        return ans;
    }
}