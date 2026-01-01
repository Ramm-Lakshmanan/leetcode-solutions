class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int[] ans=new int[n+1];
        int carry=1;
        int i=n-1;
        while(carry>0 && i>=0){
            int sum=digits[i]+carry;
            carry=sum/10;
            ans[i+1]=sum%10;
            digits[i]=sum%10;
            i--;
        }
        if(i<0 && carry>0) {
            ans[0]=carry;
            return ans;
        }
        return digits;
    }
}