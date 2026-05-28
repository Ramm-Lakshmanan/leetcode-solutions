class Solution {
    public int thirdMax(int[] nums) {
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        Set<Integer> set=new HashSet<>();
        for(int ele:nums){
            if(ele>max1){
                max3=max2;
                max2=max1;
                max1=ele;
            }
            else if(ele>max2 && ele<max1){
                max3=max2;
                max2=ele;
            }
            else if(ele>max3 && ele<max1 && ele<max2){
                max3=ele;
            }
            set.add(ele);
        }

        if(set.size()<3) return max1;
        return max3;
    }
}