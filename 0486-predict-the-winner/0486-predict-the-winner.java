class Solution {
    public int[] func(boolean first,int left,int right,int[] nums,int s1,int s2){
        if(left>right) return new int[]{s1,s2};

        if(first){
            int[] ch1=func(false,left+1,right,nums,s1+nums[left],s2);
            int[] ch2=func(false,left,right-1,nums,s1+nums[right],s2);
            if(ch1[0]>=ch2[0]) return ch1;
            return ch2;
        }
        else{
            int[] ch1=func(true,left+1,right,nums,s1,s2+nums[left]);
            int[] ch2=func(true,left,right-1,nums,s1,s2+nums[right]);
            if(ch1[1]>=ch2[1]) return ch1;
            return ch2;
        }
    }
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int s1=0,s2=0;
        int[] scores=func(true,0,n-1,nums,s1,s2);

        return scores[0]>=scores[1];
    }
}