class Solution {
    public int maxScore(int[] cards, int k) {
        int n=cards.length;
        int[] left=new int[k+1];
        int[] right=new int[k+1];

        left[0]=0;
        right[0]=0;
        for(int i=0;i<k;i++){
            left[i+1]=left[i]+cards[i];
            right[i+1]=right[i]+cards[n-i-1];
        }
        int max=0;
        for(int i=0;i<=k;i++){
            max=Math.max(max,left[i]+right[k-i]);
        }
        return max;
    }
}