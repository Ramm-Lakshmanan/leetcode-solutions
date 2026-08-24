class Solution {
    static boolean[] prime=new boolean[100001];
    static boolean built=false;
    
    public static void sieve(){
        if(!built){
            Arrays.fill(prime,true);
            for(int i=2;i<=Math.sqrt(100000);i++){
                if(prime[i]){
                    for(int j=i*i;j<=100000;j+=i){
                        prime[j]=false;
                    }
                }
            }
            built=true;
        }
    }
    
    public List<Integer> pfactors(int num){
        List<Integer> ans=new ArrayList<>();
        if(num==1) return ans;
        else if(prime[num]){
            ans.add(num);
            return ans;
        }
        
        for(int i=2;i<=Math.sqrt(num);i++){
            if(prime[i] && num%i==0){
                ans.add(i);
            }
            if(i!=num/i && prime[(num/i)] && num%(num/i)==0) ans.add(num/i);
        }
        
        return ans;
    }
    public int longestSubarray(int[] nums, int k) {
        sieve();
        List<List<Integer>> l=new ArrayList<>();
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            List<Integer> cur=pfactors(nums[i]);
            l.add(cur);
        }

        
        int left=0,right=0;
        int ans=0;

        Map<Integer,Integer> hm=new HashMap<>();

        while(right<n){
            for(int fac:l.get(right)){
                hm.put(fac,hm.getOrDefault(fac,0)+1);
            }

            while(hm.size()>k){
                for(int fac:l.get(left)){
                    hm.put(fac,hm.get(fac)-1);
                    if(hm.get(fac)==0) hm.remove(fac);
                }
                left++;
            }

            ans=Math.max(ans,right-left+1);
            right++;
        }

        return ans;
    }
}