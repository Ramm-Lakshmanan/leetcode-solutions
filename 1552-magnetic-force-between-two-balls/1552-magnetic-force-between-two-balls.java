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

        int l=Integer.MAX_VALUE,h=pos[n-1]-pos[0];

        for(int i=0;i<n-1;i++){
            l=Math.min(l,pos[i+1]-pos[i]);
        }

        int ans=-1;

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