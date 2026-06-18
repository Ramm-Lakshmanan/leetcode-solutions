class Solution {
    public void func(int target,List<Integer> temp,List<List<Integer>> ans,int[] cand,int start){
        if(target<0) return;
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<cand.length;i++){
            temp.add(cand[i]);
            func(target-cand[i],temp,ans,cand,i);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] cand, int target) {
        int n=cand.length;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        func(target,temp,ans,cand,0);
        return ans;
    }
}