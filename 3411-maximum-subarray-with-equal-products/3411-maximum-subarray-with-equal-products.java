class Solution {
    public int GCD(int a,int b){
        while(a>0 && b>0){
            if(a>b) a=a%b;
            else b=b%a;
        }
        if(a==0) return b;
        else return a;
    }
    public int maxLength(int[] nums) {
        int n=nums.length;
        int max=1;

        for(int i=0;i<n;i++){
            int prod=nums[i],lcm=nums[i],gcd=nums[i],agcd=nums[i];
            for(int j=i+1;j<n;j++){
                prod*=nums[j];
                agcd=GCD(agcd,nums[j]);
                gcd=GCD(lcm,nums[j]);
                lcm=(lcm*nums[j])/gcd;

                if(prod==(lcm*agcd)) max=Math.max(max,j-i+1);
            }
        }
        return max;
    }
}