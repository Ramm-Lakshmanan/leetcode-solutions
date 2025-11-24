class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> l=new ArrayList<>();
        long sum=0;
        for(int i:nums){
            sum=(long)((sum*2L)+(long)i)%5L;
            if(sum%5==0) l.add(true);
            else l.add(false);
        }
        return l;
    }
}