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
    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next==null) return true;

        ListNode slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode temp2=slow;
        if(fast!=null) temp2=slow.next;

        ListNode prev=head;
        ListNode temp=head.next;
        ListNode front;

        while(temp!=slow){
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }

        ListNode temp1=prev;

        while(temp1!=null && temp2!=null){
            if(temp1.val!=temp2.val) return false;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return true;
    }
}