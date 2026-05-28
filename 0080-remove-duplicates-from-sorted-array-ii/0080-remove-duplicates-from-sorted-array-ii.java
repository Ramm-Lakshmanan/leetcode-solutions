class Solution {
    public int removeDuplicates(int[] nums) {
        int ele=nums[0];
        int cnt=1;
        int k=1;

        for(int i=1;i<nums.length;i++){
            
            if(nums[i]==ele){
                cnt++;
            }
            else{
                cnt=1;
                ele=nums[i];
            }

            if(cnt<=2){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}