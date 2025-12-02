class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> hm=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) hm.add(nums[i]);
        }
        int num=1;
        while(hm.contains(num)){
            num++;
        }
        return num;
    }
}