class Solution {
    public int gcd(int a,int b){
        while(a>0 && b>0){
            if(a>b) a=a%b;
            else b=b%a;
        }
        if(a==0) return b;
        return a;
    }
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int[] prefixGcd=new int[n];
        int max=0;

        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            prefixGcd[i]=gcd(nums[i],max);
        }

        Arrays.sort(prefixGcd);

        int left=0,right=n-1;
        long res=0;
        while(left<right){
            res+=(long)gcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }

        return res;
    }
}