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

      /*if(head==null || head.next==null) return head;
      ListNode temp=head,curr=temp.next,pre=null;
      head = head.next;
      while(temp!=null && curr!=null)
      {
         temp.next = curr.next;
         curr.next = temp;
         if(pre!=null) pre.next=curr;
         if(temp.next==null) break;
         pre=temp;
         curr = temp.next.next;
         temp = temp.next;
      }
      return head;*/
      if(head==null || head.next==null) return head;
      ListNode second = head.next;
      head.next = swapPairs(head.next.next);
      second.next=head;

      return second; 
      

      
    }
}