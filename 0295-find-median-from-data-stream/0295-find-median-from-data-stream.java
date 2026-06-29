class MedianFinder {
    PriorityQueue<Integer> pq1,pq2;
    public MedianFinder() {
        pq1=new PriorityQueue<>(Collections.reverseOrder());
        pq2=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(pq1.isEmpty()){
            pq1.offer(num);
        }
        else if(num<=pq1.peek()){
            pq1.offer(num);
        }
        else{
            pq2.offer(num);
        }
        if(Math.abs(pq1.size()-pq2.size())>1){
            if(pq1.size()>pq2.size()){
                pq2.offer(pq1.poll());
            }
            else{
                pq1.offer(pq2.poll());
            }
        }
    }
    
    public double findMedian() {
        if(pq1.size()==pq2.size()){
            return ((double)pq1.peek()+(double)(pq2.peek()))/2;
        }
        else if(pq1.size()>pq2.size()) return (double)pq1.peek();
        else return (double)pq2.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */