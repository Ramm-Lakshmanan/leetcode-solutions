class Solution {
    public void func(int target,List<Integer> temp,List<List<Integer>> ans,int[] cand,int start){
        if(target<0) return;
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start;i<cand.length;i++){
            if(i>start && cand[i]==cand[i-1]) continue;
            temp.add(cand[i]);
            func(target-cand[i],temp,ans,cand,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        int n=cand.length;
        Arrays.sort(cand);

        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        func(target,temp,ans,cand,0);
        return ans;
    }
}