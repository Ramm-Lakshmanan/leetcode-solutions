class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int atmost_k=0,n=nums.length;
        Map<Integer,Integer> hm=new HashMap<>();
        int left=0,right=0;

        while(right<n){
            hm.put(nums[right],hm.getOrDefault(nums[right],0)+1);

            while(hm.size()>k){
                hm.put(nums[left],hm.get(nums[left])-1);
                if(hm.get(nums[left])==0) hm.remove(nums[left]);
                left++;
            }

            atmost_k+=(right-left+1);
            right++;
        }
        left=0;right=0;
        int atmost_k_1=0;
        hm.clear();
        while(right<n){
            hm.put(nums[right],hm.getOrDefault(nums[right],0)+1);

            while(hm.size()>k-1){
                hm.put(nums[left],hm.get(nums[left])-1);
                if(hm.get(nums[left])==0) hm.remove(nums[left]);
                left++;
            }

            atmost_k_1+=(right-left+1);
            right++;
        }

        return atmost_k-atmost_k_1;
    }
}