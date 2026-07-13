class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int k=0;

        int pos=-1,neg=-1;

        for(int i=0;i<n;i++){
            if(pos==-1 && nums[i]>0){
                pos=i;
            }
            else if(neg==-1 && nums[i]<0){
                neg=i;
            }

            if(pos!=-1 && neg!=-1) break;
        }

        while(k<n){
            if(k%2==0){
                while(nums[pos]<0) pos++;
                ans[k++]=nums[pos++];
            }
            else{
                while(nums[neg]>0) neg++;
                ans[k++]=nums[neg++];
            }
        }

        return ans;
    }
}