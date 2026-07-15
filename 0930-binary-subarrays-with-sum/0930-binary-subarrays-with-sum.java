class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> hm=new HashMap<>();
        int ans=0;hm.put(0,1);
        int sum=0;
        for(int ele:nums){
            sum+=ele;

            if(hm.containsKey(sum-goal)){
                ans+=hm.get(sum-goal);
            }

            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }

        return ans;
    }
}