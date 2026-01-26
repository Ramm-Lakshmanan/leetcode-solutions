class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            if(arr[i+1]-arr[i]<=min){
                if(arr[i+1]-arr[i]<min)
                    ans.clear();
                List<Integer> temp=new ArrayList<>();
                temp.add(arr[i]);temp.add(arr[i+1]);
                ans.add(temp);
                min=arr[i+1]-arr[i];
            }
        }
        return ans;
    }
}