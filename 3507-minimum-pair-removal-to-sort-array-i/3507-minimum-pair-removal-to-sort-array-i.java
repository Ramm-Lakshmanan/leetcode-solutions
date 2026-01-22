class Solution {
    public boolean check(List<Integer> arr){
        for(int i=0;i<arr.size()-1;i++){
            if(arr.get(i)>arr.get(i+1)) return false;
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr=new ArrayList<Integer>();
        for(int i:nums) arr.add(i);
        int cnt=0;
        while(check(arr)==false){
            int min=Integer.MAX_VALUE;
            int idx=-1;
            for(int i=0;i<arr.size()-1;i++){
                if(arr.get(i)+arr.get(i+1)<min){
                    min=arr.get(i)+arr.get(i+1);
                    idx=i;
                }
            }
            arr.remove(idx);
            arr.set(idx,min);
            cnt++;
        }
        return cnt;
    }
}