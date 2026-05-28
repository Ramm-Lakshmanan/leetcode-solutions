class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> res=new HashSet<>();

        for(int ele:nums1) set1.add(ele);

        for(int ele:nums2){
            if(set1.contains(ele)) res.add(ele);
        }

        int[] ans=new int[res.size()];
        int i=0;
        for(int ele:res){
            ans[i++]=ele;
        }
        return ans;
    }
}