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
class Solution {
    public ListNode[] rev(ListNode head,int k){
        ListNode temp=head,prev=null,front;

        while(k>0){
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
            k--;
        }
        return new ListNode[]{prev,temp};
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int n=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        if(n==1 || k==1) return head;
        
        temp=head;
        ListNode[] res=rev(temp,k);
        ListNode prev=temp;
        temp=res[1];
        ListNode nhead=res[0];

        for(int i=1;i<(n/k);i++){
            res=rev(temp,k);
            prev.next=res[0];
            prev=temp;
            temp=res[1];
        }
        
        while(temp!=null){
            prev.next=temp;
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
        return nhead;
    }
}