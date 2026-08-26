class Solution {
    public int func(int[] pos,int diff){
        int prev=pos[0];
        int cnt=1;
        for(int i=1;i<pos.length;i++){
            if(Math.abs(pos[i]-prev)>=diff){
                cnt++;
                prev=pos[i];
            }
        }
        return cnt;
    }
    public int maxDistance(int[] pos, int m){
        int n=pos.length;
        Arrays.sort(pos);
        int ans=-1;

        int l=1,h=999999999;
        while(l<=h){
            int mid=l+(h-l)/2;

            int cur=func(pos,mid);

            
            if(cur>=m){
                ans=mid;
                l=mid+1;
            }
            else h=mid-1;

        }

        return ans;
        
    }
}