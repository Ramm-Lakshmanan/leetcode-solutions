class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n=words.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                boolean flag=true;
                for(int k=0;k<Math.min(words[i].length(),words[j].length());k++){
                    if(words[i].charAt(k)!=words[j].charAt(k)){
                        if(order.indexOf(words[i].charAt(k))>order.indexOf(words[j].charAt(k))){
                            return false;
                        }
                        flag=false;
                        break;
                    }
                }
                if(flag && words[i].length()>words[j].length()) return false;
            }
        }
        return true;
    }
}