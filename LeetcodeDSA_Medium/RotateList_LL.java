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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode temp=head;
        int n=1;
        while(temp.next!=null)
        {
            temp=temp.next;
            n++;
        }
        temp.next=head;
        k=k%n;
        int end=n-k;
        while(end>0) {
            temp=temp.next;
            end--;
        }
        head=temp.next;
        temp.next=null;
        
        return head;
    }
}
