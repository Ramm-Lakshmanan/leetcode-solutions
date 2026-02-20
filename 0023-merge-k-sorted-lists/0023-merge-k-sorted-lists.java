/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class pair{
    ListNode node;
    int val;
    public pair(ListNode node,int val){
        this.node=node;
        this.val=val;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode nhead=new ListNode(-1);
        ListNode temp=nhead;
        PriorityQueue<pair> pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a.val,b.val)
        );
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null) pq.offer(new pair(lists[i],lists[i].val));
        }
        while(!pq.isEmpty()){
            pair now=pq.poll();
            ListNode curr=now.node;
            temp.next=curr;
            if(curr.next!=null){
                pq.offer(new pair(curr.next,curr.next.val));
            }
            temp=temp.next;
        }

        return nhead.next;
    }
}