class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);

        if(nums1[0]%2!=0) return true;
        else{
            for(int ele:nums1){
                if(ele%2!=0) return false;
            }
            return true;
        }
    }
}