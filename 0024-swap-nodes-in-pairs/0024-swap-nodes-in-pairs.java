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
    public ListNode swapPairs(ListNode head) {
        ListNode temp=new ListNode(0);
        temp.next=head;
        ListNode prev=temp;
        while(prev.next!=null && prev.next.next!=null){
            ListNode first=prev.next;
            ListNode sec=first.next;
            first.next=sec.next;
            sec.next=first;
            prev.next=sec;
            prev=first;
        }
        return temp.next;
    }
}