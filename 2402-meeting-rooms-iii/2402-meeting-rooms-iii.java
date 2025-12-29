class pair{
    int rno;
    long ftime;

    public pair(int room_no,long free_time){
        rno=room_no;
        ftime=free_time;
    }
}
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int len=meetings.length;
        Arrays.sort(meetings,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int[] rooms=new int[n];
        int present=0;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            if(a.ftime!=b.ftime)return Long.compare(a.ftime,b.ftime);
            return Integer.compare(a.rno,b.rno);
        });
        PriorityQueue<Integer> req=new PriorityQueue<>();
        for(int i=0;i<len;i++){
            while(!pq.isEmpty() && pq.peek().ftime<=(long)meetings[i][0])
                req.offer(pq.poll().rno);
            
            if(req.isEmpty()){
                if(present<n){
                    rooms[present]++;
                    pq.offer(new pair(present,(long)meetings[i][1]));
                    present++;
                }
                else{
                    pair curr=pq.poll();
                    rooms[curr.rno]++;
                    long summa=meetings[i][1]-meetings[i][0];
                    pq.offer(new pair(curr.rno,curr.ftime+summa));
                }
            }
            else{
                int rno=req.poll();
                rooms[rno]++;
                pq.offer(new pair(rno,(long)meetings[i][1]));
            }
        }
        int max=Integer.MIN_VALUE;
        int idx=-1;
        for(int i=0;i<n;i++){
            if(rooms[i]>max) {
                idx=i;
                max=rooms[i];
            }
        }
        return idx;
    }
}