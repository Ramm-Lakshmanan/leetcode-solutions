class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int pos=0,neg=1;

        for(int ele:nums){
            if(ele>0){
                ans[pos]=ele;
                pos+=2;
            }
            else{
                ans[neg]=ele;
                neg+=2;
            }
        }

        return ans;
    }
}