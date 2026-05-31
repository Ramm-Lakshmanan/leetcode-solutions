class Solution {
    public boolean asteroidsDestroyed(int mass, int[] ast) {
        Arrays.sort(ast);
        long m=(long)mass;
        for(int ele:ast){
            if(m<(long)ele) return false;
            m+=(long)ele;
        }
        return true;
    }
}