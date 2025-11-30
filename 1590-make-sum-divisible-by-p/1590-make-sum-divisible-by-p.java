class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        int rem=0;
        for(int i=0;i<n;i++){
            rem=(rem+nums[i])%p;
        }
        if(rem==0) return 0;
        else{
            int min=Integer.MAX_VALUE;
            Map<Integer,Integer> hm=new HashMap<>();
            hm.put(0,0);
            int curr=0;
            for(int i=0;i<n;i++){
                curr=(curr+nums[i])%p;
                if(curr==rem){
                    if(i+1-hm.get(0)<min) min=i+1-hm.get(0);
                }
                else if (hm.containsKey((curr - rem + p) % p)) {
                    int key = (curr - rem + p) % p;
                    min = Math.min(min, i + 1 - hm.get(key));
                }
                hm.put(curr,i+1);
            }
            if(min==Integer.MAX_VALUE || min==n) return -1;
            return min;
        }
    }
}