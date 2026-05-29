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
    public ListNode deleteDuplicates(ListNode head) {
        while(head!=null){
            int og=head.val;
            if(head.next!=null && head.next.val==og){
                while(head!=null && head.val==og){
                    head=head.next;
                }
            }
            else{
                break;
            }
        }
        if(head==null || head.next==null) return head;
        ListNode prev=head;
        ListNode temp=head.next;

        while(temp!=null){
            int cur=temp.val;
            if(temp.next!=null && temp.next.val==cur){
                while(temp!=null && temp.val==cur) temp=temp.next;
                prev.next=temp;
            }
            else {
                prev=temp;
                temp=temp.next;
            }
        }
        return head;
    }
}