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

        if(lists==null || lists.length==0) return null;
        return DivideandConquer(lists,0,lists.length-1);
    }
     private ListNode DivideandConquer(ListNode[] lists, int start, int end)
     {
         if(start>end) return null;
         if(start==end) return lists[start];
         int mid=start+(end-start)/2;
         ListNode left = DivideandConquer(lists, start, mid);
         ListNode right=DivideandConquer(lists, mid+1, end);
         return mergeList(left, right);

     }
     private ListNode mergeList(ListNode n1, ListNode n2) {
  ListNode dummy = new ListNode(-1);
  ListNode prev = dummy;
  while (n1 != null && n2 != null) {
    if (n1.val < n2.val) {
      prev.next = n1;
      n1 = n1.next;
    } else {
      prev.next = n2;
      n2 = n2.next;
    }
    prev = prev.next;
  }
  prev.next = (n1 != null) ? n1 : n2;

  return dummy.next;
}
    
}
