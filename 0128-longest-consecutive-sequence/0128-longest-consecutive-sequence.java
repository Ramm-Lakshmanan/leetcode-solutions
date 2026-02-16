class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> hm=new HashMap<>();
        int ans=0;

        for(int ele:nums){
            hm.put(ele,0);
        }

        for(int ele:hm.keySet()){
            int cnt=1;
            if(hm.get(ele)==0){
                int curr=ele;
                hm.put(curr,1);
                while(hm.containsKey(curr+1)){
                    cnt++;
                    hm.put(curr+1,1);
                    curr++;
                }
            }
            ans=Math.max(ans,cnt);
        }
        return ans;
    }
}