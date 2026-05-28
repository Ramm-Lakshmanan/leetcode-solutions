class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> ans=new HashSet<>();

        int left=0,right=0;

        while(left<nums1.length && right<nums2.length){
            if(nums1[left]==nums2[right]){
                ans.add(nums1[left]);
                left++;
                right++;
            }
            else if(nums1[left]<nums2[right]){
                left++;
            }
            else right++;
        }
        int[] res=new int[ans.size()];
        int i=0;
        for(int ele:ans){
            res[i++]=ele;
        }
        return res;
    }
}