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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<lists.length;i++){
            ListNode head=lists[i];
            if(head!=null) pq.add(head);
        }
        ListNode temp=new ListNode(0);
        ListNode curr=temp;
        while(!pq.isEmpty()){
            ListNode temp1=pq.poll();
            curr.next=temp1;
            curr=curr.next;
            if(temp1.next!=null){
                pq.add(temp1.next);
            }
        }
        return temp.next;
    }
}