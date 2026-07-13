class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans=0;
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int sum=0;
        for(int ele:nums){
            sum+=ele;

            if(hm.containsKey(sum-k)){
                ans+=hm.get(sum-k);
            }

            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }

        return ans;
    }
}