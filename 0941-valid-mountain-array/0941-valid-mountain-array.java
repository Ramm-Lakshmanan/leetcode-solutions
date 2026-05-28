class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3) return false;

        int i;boolean flag1=false,flag2=false;

        for(i=0;i<arr.length-1;i++){
            if(arr[i]>=arr[i+1]){
                if(arr[i]==arr[i+1]) return false;
                break;
            }
            else flag1=true;
        }
        for(int j=i;j<arr.length-1;j++){
            if(arr[j]<=arr[j+1]){
                return false;
            }
            else flag2=true;
        }

        if(flag1 && flag2)
            return true;
        return false;
    }
}