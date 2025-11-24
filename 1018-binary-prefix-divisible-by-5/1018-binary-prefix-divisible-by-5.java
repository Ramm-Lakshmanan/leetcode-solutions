class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> l=new ArrayList<>();
        int sum=0;
        for(int i:nums){
            sum=(sum*2+i)%5;
            if(sum==0) l.add(true);
            else l.add(false);
        }
        return l;
    }
}