class Solution {
    public List<String> ans(String digits,int n,List<String> res,String[] combn){
        if(n<0) return res;

        int len=res.size();
        int curr=digits.charAt(n)-'0'-2;
        for(int i=0;i<len;i++){
            for(int j=0;j<combn[curr].length();j++){
                String s=Character.toString(combn[curr].charAt(j))+res.get(i);
                res.add(s);
            }
        }
        
        for(int i=0;i<len;i++){
            res.remove(0);
        }
        return ans(digits,n-1,res,combn);
    }
    public List<String> letterCombinations(String digits) {
        int n=digits.length();
        String[] combn={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res=new ArrayList<>();
        int curr=digits.charAt(n-1)-'0'-2;
        for(int i=0;i<combn[curr].length();i++){
            res.add(Character.toString(combn[curr].charAt(i)));
        }
        res=ans(digits,n-2,res,combn);
        return res;
    }
}