class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n=nums.length;
        int max=-1;
        for(int ele:nums) max=Math.max(max,ele);

        int[] spf=new int[max+1];

        for(int i=0;i<max+1;i++) spf[i]=i;

        for(int i=2;i*i<=max;i++){
            if(spf[i]==i){
                for(int j=i*i;j<=max;j+=i){
                    if(spf[j]==j) spf[j]=i;
                }
            }
        }

        List<Integer>[] fac=new ArrayList[n];

        for(int i=0;i<n;i++) fac[i]=new ArrayList<>();

        for(int i=0;i<n;i++){
            int temp=nums[i];

            while(temp>1){
                int d=spf[temp];
                fac[i].add(d);
                while(temp%d==0) temp/=d;
            }
        }

        Map<Integer,Integer> hm=new HashMap<>();

        int left=0,right=0,ans=0;

        while(right<n){
            for(int f:fac[right]){
                hm.put(f,hm.getOrDefault(f,0)+1);
            }

            while(hm.size()>k){
                for(int f:fac[left]){
                    hm.put(f,hm.get(f)-1);
                    if(hm.get(f)==0) hm.remove(f);
                }
                left++;
            }
            ans=Math.max(ans,right-left+1);
            right++;
        }

        return ans;
    }
}