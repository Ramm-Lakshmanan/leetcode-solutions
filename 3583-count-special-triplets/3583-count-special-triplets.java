class Solution {
    public int specialTriplets(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> hm1=new HashMap<>();
        int cnt0=0;
        for(int i=0;i<n;i++){
            hm1.put(nums[i],hm1.getOrDefault(nums[i],0)+1);
            if(nums[i]==0)cnt0++;
        }
        long res=0;
        long mod=1000000007;
        Map<Integer,Integer> hm2=new HashMap<>();
        boolean flag=false;
        hm2.put(nums[0],1);
        hm1.put(nums[0],hm1.get(nums[0])-1);
        for(int i=1;i<n;i++){
            hm1.put(nums[i],hm1.get(nums[i])-1);
            if(hm2.containsKey(2*nums[i]) && hm1.get(2*nums[i])!=0){
                long left=hm2.get(nums[i]*2);
                long tot=hm1.get(2*nums[i]);
                res+=((left*(tot))%mod);
            }
            hm2.put(nums[i],hm2.getOrDefault(nums[i],0)+1);
        }
        
        return (int)(res%mod);
    }
}