class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum=0;
        for(int i:apple) sum+=i;
        int cnt=0;
        for(int i=capacity.length-1;i>=0;i--){
            cnt++;
            sum-=capacity[i];
            if(sum<=0) return cnt;
        }
        return 0;
    }
}