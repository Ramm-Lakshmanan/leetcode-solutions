class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis=new ArrayList<>();
        lis.add(nums[0]);

        for(int ele:nums){
            if(ele>lis.get(lis.size()-1)){
                lis.add(ele);
            }
            else{
                int idx=Collections.binarySearch(lis,ele);
                if(idx<0){
                    idx=Math.abs(idx)-1;
                    lis.set(idx,ele);
                }
            }
        }
        return lis.size();
    }
}