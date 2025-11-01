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
    ListNode prev;
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums) set.add(n);
        while(head!=null && set.contains(head.val)){
            head=head.next;
        }
        if(head==null) return head;
        ListNode node=head;
        while(node.next!=null){
            if(set.contains(node.next.val)){
                node.next=node.next.next;
            }else{
                node=node.next;
            }
        }
        return head;
    }
}