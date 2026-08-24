class Solution {
    public int gcd(int a,int b){
        while(a>0 && b>0){
            if(a>b) a=a%b;
            else b=b%a;
        }

        return (a==0)?b:a;
    }
    public int subarrayLCM(int[] nums, int k) {
        int ans=0;

        int n=nums.length;

        for(int i=0;i<n;i++){
            int lcm=nums[i];
            if(lcm==k) ans++;

            for(int j=i+1;j<n;j++){

                lcm=lcm*nums[j]/gcd(lcm,nums[j]);

                if(lcm==k) ans++;
                else if(lcm>k) break;
            }
        }

        return ans;
    }
}