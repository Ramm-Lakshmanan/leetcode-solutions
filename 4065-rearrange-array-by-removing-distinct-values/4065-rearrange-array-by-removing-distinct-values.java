class Solution {
    public int[] rearrangeArray(int[] nums) {
        Map<Integer,Integer> hm=new TreeMap<>();
        for(int ele:nums) hm.put(ele,hm.getOrDefault(ele,0)+1);

        int[] ans=new int[nums.length];
        int k=0;
        while(!hm.isEmpty()){
            List<Integer> rm=new ArrayList<>();
            for(int key:hm.keySet()){
                ans[k++]=key;
                hm.put(key,hm.get(key)-1);
                if(hm.get(key)==0) rm.add(key);
            }
            for(int r:rm) hm.remove(r);
        }
        return ans;
    }
}