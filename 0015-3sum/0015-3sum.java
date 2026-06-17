class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;

        List<List<Integer>> ans=new ArrayList<>();
        int i=0;
        while(i<n-2){

            int j=i+1,k=n-1;
            

            while(j<k){
                int sum=nums[i]+nums[k]+nums[j];
                if(sum>0){
                    k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) k--;
                    j++;
                    k--;
                }
            }
            while(i<n-2 && nums[i]==nums[i+1]) i++;
            i++;
        }
        return ans;
    }
}