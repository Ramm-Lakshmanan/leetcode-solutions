class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);

        int[] path=new int[n];int[] lds=new int[n];
        Arrays.fill(path,-1);Arrays.fill(lds,1);
        int ans=1;
        int idx=0;

        for(int i=1;i<n;i++){
            int max=lds[i];
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && lds[j]+1>max){
                    max=lds[j]+1;
                    path[i]=j;
                }
            }
            lds[i]=max;
            if(lds[i]>ans){
                idx=i;
                ans=lds[i];
            }
        }

        while(idx>=0){
            res.add(nums[idx]);
            idx=path[idx];
        }
        return res;
    }
}