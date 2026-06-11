class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        List<Integer> dp=triangle.get(n-1);

        for(int i=n-2;i>=0;i--){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<dp.size()-1;j++){
                temp.add(Math.min(dp.get(j),dp.get(j+1))+triangle.get(i).get(j));
            }
            dp=temp;
        }
        return dp.get(0);
    }
}