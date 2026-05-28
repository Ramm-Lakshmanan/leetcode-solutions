class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> hm1=new HashMap<>();
        List<Integer> res=new ArrayList<>();

        for(int ele:nums1){
            hm1.put(ele,hm1.getOrDefault(ele,0)+1);
        }

        for(int ele:nums2){
            if(hm1.getOrDefault(ele,0)>0){
                res.add(ele);
                hm1.put(ele,hm1.get(ele)-1);
            }
        }

        int[] ans=new int[res.size()];
        int i=0;
        for(int ele:res){
            ans[i++]=ele;
        }  
        return ans;      
    }
}