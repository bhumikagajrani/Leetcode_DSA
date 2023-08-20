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

        ListNode newHead=new ListNode(0);
        newHead.next=head;
        ListNode prev=newHead;
        
        while(head!=null) {
        if(head.next!=null && head.val==head.next.val)
        {
            while(head.next!=null && head.val==head.next.val)
            {
                head=head.next;
            }
            prev.next=head.next;
        }
            else
            {
                prev=prev.next;
            }
            head=head.next;
    }

        return newHead.next;
    }
}
