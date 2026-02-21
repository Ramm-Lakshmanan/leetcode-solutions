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
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode temp1=head1;
        ListNode temp2=head2;
        ListNode head=new ListNode(-1);
        ListNode temp=head;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                temp.next=temp1;
                temp=temp.next;
                temp1=temp1.next;
            }
            else{
                temp.next=temp2;
                temp=temp.next;
                temp2=temp2.next;
            }
        }

        while(temp1!=null){
            temp.next=temp1;
            temp=temp.next;
            temp1=temp1.next;
        }
        while(temp2!=null){
            temp.next=temp2;
            temp=temp.next;
            temp2=temp2.next;
        }
        temp.next=null;
        return head.next;
    }
    public ListNode merge_sort(ListNode[] lists,int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            ListNode head1=merge_sort(lists,low,mid);
            ListNode head2=merge_sort(lists,mid+1,high);
            ListNode head=merge(head1,head2);
            return head;
        }
        else if(low==high) return lists[low];
        return null;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        return merge_sort(lists,0,n-1);
    }
}