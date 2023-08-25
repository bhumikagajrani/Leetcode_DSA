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

        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        PriorityQueue<ListNode> minheap = new PriorityQueue<>(
            (o1,o2)->{return o1.val-o2.val;
            }
        );
         for(int i=0;i<lists.length;i++)
         {
             if(lists[i]!=null)
             {
                 minheap.offer(lists[i]);
             }
         }
        
        while(minheap.size()>0)
        {
            ListNode curr=minheap.poll();
            temp.next=curr;
            temp=curr;
            if(curr.next!=null)
            {
                minheap.offer(curr.next);
            }
        }
        return dummy.next;
    }
    
}
