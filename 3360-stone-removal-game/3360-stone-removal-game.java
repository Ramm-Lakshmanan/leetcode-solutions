class Solution {
    public boolean canAliceWin(int n) {
        int cnt=0;
        for(int i=0;i<10;i++){
            if(n<cnt+(10-i)){
                if(i%2==0) return false;
                return true;
            }
            cnt+=(10-i);
        }
        return false;
    }
}