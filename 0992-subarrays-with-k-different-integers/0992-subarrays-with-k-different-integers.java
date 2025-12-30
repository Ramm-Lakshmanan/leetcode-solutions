class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        // EXACTLY -K SUBARRAYS= ATMOST K - ATMOST (K-1)

        int n=nums.length;
        Map<Integer,Integer> hm=new HashMap<>();
        int atmost_k=0; 
        int left=0,right=0;

        while(right<n){
            hm.put(nums[right],hm.getOrDefault(nums[right],0)+1);

            if(hm.size()>k){
                while(left<right && hm.get(nums[left])>1){
                    hm.put(nums[left],hm.get(nums[left])-1);
                    left++;
                }
                hm.remove(nums[left]);
                left++;
            }
            atmost_k+=(right-left+1);
            right++;
        }       
        hm.clear();
        left=0;right=0;
        int atmost_k_1=0;
        while(right<n){
            hm.put(nums[right],hm.getOrDefault(nums[right],0)+1);

            if(hm.size()>k-1){
                while(left<right && hm.get(nums[left])>1){
                    hm.put(nums[left],hm.get(nums[left])-1);
                    left++;
                }
                hm.remove(nums[left]);
                left++;
            }
            atmost_k_1+=(right-left+1);
            right++;
        }
        return atmost_k-atmost_k_1;
    }
}