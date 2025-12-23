class Solution {
    public int maxTwoEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        List<Integer> start=new ArrayList<>();
        List<Integer> value=new ArrayList<>();

        for(int i=0;i<n;i++){
            int idx=Collections.binarySearch(start,events[i][0]);
            if(idx<0){
                start.add(events[i][0]);
                value.add(events[i][2]);
            }
            else{
                value.set(idx,Math.max(value.get(idx),events[i][2]));
            }
        }
        for(int i=value.size()-2;i>=0;i--){
            value.set(i,Math.max(value.get(i),value.get(i+1)));
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int curr=events[i][2];
            if(events[i][1]+1>start.get(start.size()-1)) max=Math.max(max,curr);
            else{
                int idx=Collections.binarySearch(start,events[i][1]+1);
                if(idx<0) idx=Math.abs(idx+1);
                curr+=value.get(idx);
                max=Math.max(max,curr);
            }
        }
        return max;
    }
}