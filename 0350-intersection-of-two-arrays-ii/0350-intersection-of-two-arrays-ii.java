class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> hm1=new HashMap<>();
        Map<Integer,Integer> hm2=new HashMap<>();
        Map<Integer,Integer> res=new HashMap<>();

        for(int ele:nums1){
            hm1.put(ele,hm1.getOrDefault(ele,0)+1);
        }

        for(int ele:nums2){
            hm2.put(ele,hm2.getOrDefault(ele,0)+1);
        }
        int tot=0;
        for(int ele:hm1.keySet()){
            if(hm2.containsKey(ele)){
                int cnt=Math.min(hm1.get(ele),hm2.get(ele));
                tot+=cnt;
                res.put(ele,cnt);
            }
        }

        int[] ans=new int[tot];
        int i=0;
        for(int ele:res.keySet()){
            for(int j=0;j<res.get(ele);j++){
                ans[i++]=ele;
            }
        }  
        return ans;      
    }
}