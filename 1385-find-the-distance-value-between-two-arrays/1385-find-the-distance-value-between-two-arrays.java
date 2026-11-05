class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans=0;
        for(int ele1:arr1){
            boolean flag=true;
            for(int ele2:arr2){
                if(Math.abs(ele1-ele2)<=d){
                    flag=false;
                }
            }
            if(flag) ans++;
        }
        return ans;
    }
}