class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Integer[] num1=new Integer[nums1.length];
        for(int i=0;i<nums1.length;i++){
            num1[i]=nums1[i];
        }
        Collections.addAll(set1,num1);
        
        Set<Integer> set2=new HashSet<>();
        Integer[] num2=new Integer[nums2.length];
        for(int i=0;i<nums2.length;i++){
            num2[i]=nums2[i];
        }
        Collections.addAll(set2,num2);

        Set<Integer> Intersection=new HashSet<>(set1);
        Intersection.retainAll(set2);

        int[] ans=new int[Intersection.size()];
        int i=0;
        for(int ele:Intersection){
            ans[i++]=ele;
        }
        return ans;
    }
}