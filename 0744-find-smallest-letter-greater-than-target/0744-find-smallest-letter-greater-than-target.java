class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int idx=-1;

        int low=0,high=letters.length-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(letters[mid]<=target){
                low=mid+1;
            }
            else{
                idx=mid;
                high=mid-1;
            }
        }
        if(idx==-1) return letters[0];
        else return letters[idx];
    }
}