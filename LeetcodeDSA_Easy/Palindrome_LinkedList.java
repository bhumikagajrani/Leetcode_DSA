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
        ListNode slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headT=slow.next,pre=null,nextt=null;
        while(headT!=null)
        {
            nextt=headT.next;
            headT.next=pre;
            pre=headT;
            headT=nextt;
        }
        slow.next=pre;
        slow=slow.next;
        while(slow!=null)
        {
            if(head.val!=slow.val)
            {
                return false;
            }
            head=head.next;
            slow=slow.next;
        }
        return true;

    }
}