class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder sb=new StringBuilder();
        int cn=columnNumber;

        while(cn>0){
            char s;
            if(cn%26==0) {
                s='Z';
                cn=(cn/26)-1;
            }
            else {
                s=(char)((cn%26)+64);
                cn=(cn/26);
            }
            sb.append(Character.toString(s));
            
        }
        sb.reverse();
        return sb.toString();
    }
}