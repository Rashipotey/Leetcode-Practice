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
    public ListNode reverse(ListNode start, ListNode end) {
        ListNode prev=null, curr=start;
        while(curr!=end){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        ListNode temp=head;
        while(temp!=null && count<k){
            temp=temp.next;
            count++;
        }
        if(count<k) return head;

        ListNode newHead=reverse(head, temp);
        head.next=reverseKGroup(temp, k);
        return newHead;

    }
}